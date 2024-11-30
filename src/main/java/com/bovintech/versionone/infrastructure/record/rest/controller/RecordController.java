package com.bovintech.versionone.infrastructure.record.rest.controller;

import com.bovintech.versionone.application.record.command.CreateRecordHandler;
import com.bovintech.versionone.application.record.query.RecordGetByCattleIdHandler;
import com.bovintech.versionone.application.record.query.RecordGetPerMonthHandler;
import com.bovintech.versionone.domain.record.model.dto.CreateRecordDto;
import com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto;
import com.bovintech.versionone.domain.record.model.dto.Record;
import com.bovintech.versionone.domain.record.model.dto.ShowRecordDto;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {

    private final CreateRecordHandler createRecordHandler;
    private final RecordGetByCattleIdHandler recordGetByCattleIdHandler;
    private final RecordGetPerMonthHandler recordGetPerMonthHandler;

    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseHandler<ShowRecordDto> create(@PathVariable Long id,
                                                 @RequestParam("date_of_record") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateOfRecord,
                                                 @RequestParam ("weight") Integer weight,
                                                 @RequestParam ("img") MultipartFile img) {

        ShowRecordDto record = createRecordHandler.execute(id, new CreateRecordDto(dateOfRecord, weight, img));
        return ResponseHandler.success("Registro creado correctamente", record);
    }

    @GetMapping("/by-cattle/{cattleId}")
    public ResponseHandler<List<ShowRecordDto>> getRecordsByCattleId(@PathVariable("cattleId") Long cattleId) {
        List<ShowRecordDto> records = recordGetByCattleIdHandler.execute(cattleId);
        return ResponseHandler.success("Records fetched successfully", records);
    }

    @GetMapping("/MaxWeightByMonthForCattle/{cattleId}")
    public ResponseHandler<List<MaxWeightPerMonthDto>> getMaxWeightPerMonth(@PathVariable("cattleId") Long cattleId) {
        return ResponseHandler.success("Max Weight Records PerMonth successfully", recordGetPerMonthHandler.execute(cattleId));
    }

}
