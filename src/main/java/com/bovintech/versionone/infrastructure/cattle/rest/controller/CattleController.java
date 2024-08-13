package com.bovintech.versionone.infrastructure.cattle.rest.controller;

import com.bovintech.versionone.application.cattle.command.CattleCreateHandler;
import com.bovintech.versionone.application.cattle.query.CattleAllHandler;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.command.CattleCreateDTO;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cattle")
@RequiredArgsConstructor
public class CattleController {
    private final CattleAllHandler cattleAllHandler;
    private final CattleCreateHandler cattleCreateHandler;

    @GetMapping
    public ResponseEntity<ResponseHandler<Page<Cattle>>> getAll(@RequestParam(required = false) String gender,
                                                                @RequestParam(required = false) String breed,
                                                                @PageableDefault(page = 0, size= 10) Pageable pageable){
        return ResponseHandler.success("Se recuperaron con éxito todos los registros de ganado.",cattleAllHandler.execute(new CattleSearchParams(gender, breed),pageable));
    }

    @PostMapping
    public ResponseEntity<ResponseHandler<Cattle>> create (@RequestBody @Valid CattleCreateDTO cattleCreateDTO){
        return ResponseHandler.success("Bovino creado correctamente", cattleCreateHandler.execute(cattleCreateDTO));
    }

}
