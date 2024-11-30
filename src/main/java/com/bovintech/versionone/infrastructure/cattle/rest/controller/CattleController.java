package com.bovintech.versionone.infrastructure.cattle.rest.controller;

import com.bovintech.versionone.application.cattle.command.*;
import com.bovintech.versionone.application.cattle.query.CattleAllHandler;
import com.bovintech.versionone.application.cattle.query.CattleGetByIdHandler;
import com.bovintech.versionone.application.cattle.query.CattleGetOffSpringHandler;
import com.bovintech.versionone.application.cattle.query.CattleGetOngoingBirthHandler;
import com.bovintech.versionone.application.log.command.LoggerHandler;
import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.cattle.model.dto.*;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthCreateDto;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthRecords;
import com.bovintech.versionone.domain.cattle.model.dto.command.CattleCreateDTO;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import com.bovintech.versionone.domain.cattle.usecases.LotCreateUseCase;
import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cattle")
@RequiredArgsConstructor
public class CattleController {
    private final CattleAllHandler cattleAllHandler;
    private final CattleCreateHandler cattleCreateHandler;
    private final CattleGetByIdHandler cattleGetByIdHandler;
    private final CattleGetOffSpringHandler cattleGetOffSpringHandler;
    private final BirthCreateHandler birthCreateHandler;
    private final CattleGetOngoingBirthHandler cattleGetOngoingBirthHandler;
    private final CattleRecordBirthHandler cattleRecordBirthHandler;
    private final LotGetAllHandler lotGetAllHandler;
    private final LotGetAllByOperatorHandler lotGetAllByOperatorHandler;
    private final LotCreateUseCase lotCreateUseCase;

    private final LoggerHandler loggerHandler;

    @GetMapping
    public ResponseHandler<Page<CattleShowDto>> getAll(@RequestParam(required = false) String gender,
                                                       @RequestParam(required = false) List<String> breed,
                                                       @RequestParam(required = false) String brand,
                                                       @RequestParam(required = false) Long lotId,
                                                       @PageableDefault(page = 0, size= 10) Pageable pageable){
        return ResponseHandler.success("Se recuperaron con éxito todos los registros de ganado.",cattleAllHandler.execute(new CattleSearchParams(lotId,gender, breed,brand),pageable));
    }

    @GetMapping("/{id}")
    public ResponseHandler<CattleShowByIdDto> getById(@PathVariable Long id){
        return ResponseHandler.success("Se recupero con éxito el bovino", cattleGetByIdHandler.execute(id));
    }

    @GetMapping("lot")
    public ResponseHandler<Page<LotShowDto>> getAllLots(@PageableDefault(page = 0, size= 10) Pageable pageable){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseHandler.success("Se recupero con éxito el bovino", lotGetAllHandler.execute(authentication.getName(), pageable));
        }

        return ResponseHandler.success("Se recupero con éxito el bovino", lotGetAllByOperatorHandler.execute(authentication.getName(), pageable));
    }

    @GetMapping("lots")
    public ResponseHandler<List<LotShowDto>> getAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseHandler.success("Se recupero con éxito el bovino", lotGetAllHandler.execute(authentication.getName()));
        }

        return ResponseHandler.success("Se recupero con éxito el bovino", lotGetAllByOperatorHandler.execute(authentication.getName()));
    }


    @PostMapping("lot")
    public ResponseHandler<LotDto> createLot (@RequestBody @Valid LotCreateDto lotCreateDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LotDto lot = lotCreateUseCase.execute(authentication.getName(),lotCreateDto);
        loggerHandler.info("Lote: "+lot.getName()+" creado correctamente", ModuleType.LOT,  ActionType.CREATE);
        return ResponseHandler.success("Lote creado correctamente", lot);
    }


    @GetMapping("offspring/{id}")
    public ResponseHandler<Page<CattleShowDto>> getOffSpring(@PathVariable Long id, @PageableDefault(page = 0, size= 10) Pageable pageable){
        return ResponseHandler.success("Se recupero los descendientes con exito",cattleGetOffSpringHandler.execute(id, pageable));
    }

    @PostMapping
    public ResponseHandler<Cattle> create (@RequestBody @Valid CattleCreateDTO cattleCreateDTO){
        Cattle bovine = cattleCreateHandler.execute(cattleCreateDTO);
        loggerHandler.info("Bovino: "+bovine.getBrand()+" creado correctamente", ModuleType.CATTLE, ActionType.CREATE);
        return ResponseHandler.success("Bovino creado correctamente", bovine);
    }

    @PostMapping("{id}/birth")
    public ResponseHandler<BirthDto> createBirth (@PathVariable Long id, @RequestBody @Valid BirthCreateDto birthCreateDto){
        BirthDto birthDto =  birthCreateHandler.execute(id, birthCreateDto);
        loggerHandler.info("Inseminación del bovino: "+birthDto.getDam().getBrand()+" creada correctamente",ModuleType.BIRTH,  ActionType.CREATE);
        return ResponseHandler.success("Parto creado correctamente",birthDto);
    }

    @GetMapping("{id}/birth")
    public ResponseHandler<BirthRecords> getBirth (@PathVariable Long id){
        return ResponseHandler.success("Parto creado correctamente", cattleGetOngoingBirthHandler.execute(id));
    }

    @PostMapping(value ="birth/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseHandler<BirthDto> getBirth (@PathVariable Long id,
                                               @RequestParam ("brand") String brand,
                                               @RequestParam ("gender") String gender,
                                               @RequestParam ("breed") String breed,
                                               @RequestParam ("distinctiveTrait") String distinctiveTrait,
                                               @RequestParam("birthDate") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate birthDate,
                                               @RequestParam ("weight") Integer weight,
                                               @RequestParam ("img") MultipartFile img){


        CattleBirthRecord birthToSave =  CattleBirthRecord.builder()
                .dateOfBirth(birthDate)
                .brand(brand)
                .gender(gender)
                .breed(breed)
                .distinctiveTrait(distinctiveTrait)
                .img(img)
                .weight(weight)
                .dateOfRecord(birthDate)
                .build();

        BirthDto birthDto = cattleRecordBirthHandler.execute(id, birthToSave);
        loggerHandler.info("Nuevo parto registrado  correctamente: "+birthDto.getCalf().getBrand(),ModuleType.BIRTH, ActionType.CREATE);
        return ResponseHandler.success("Parto creado correctamente", birthDto);
    }


}
