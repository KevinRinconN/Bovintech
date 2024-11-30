package com.bovintech.versionone.infrastructure.log.rest.controller;

import com.bovintech.versionone.application.log.query.LogGetAllHandler;
import com.bovintech.versionone.domain.event.model.constant.EventType;
import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.domain.log.model.dto.LogGetDto;
import com.bovintech.versionone.domain.log.model.dto.LogSearchParams;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {

    private final LogGetAllHandler logGetAllHandler;

    @GetMapping
    public ResponseHandler<Page<LogGetDto>> getAll (@RequestParam(required = false) List<ActionType> action,
                                                    @RequestParam(required = false) List<ModuleType> module,
                                                    @RequestParam(required = false) LocalDateTime date,
                                                    @RequestParam(required = false) List<String> operators,
                                                    @PageableDefault(page = 0, size= 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseHandler.success("Log data successfully",logGetAllHandler.execute(new LogSearchParams(date,action, module,operators, pageable)));
    }
}
