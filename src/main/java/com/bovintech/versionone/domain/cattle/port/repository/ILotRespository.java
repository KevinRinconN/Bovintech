package com.bovintech.versionone.domain.cattle.port.repository;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILotRespository {
    Page<LotDto> findAll(String idOwner,Pageable pageable);
    List<LotDto> findAll(String idOwner);
    List<LotDto> findAllById (List<Long> lots);
    Page<LotDto> findAllCattleByOperator(String operator,Pageable pageable);
    List<LotDto> findAllCattleByOperator(String operator);
    LotDto create (LotDto lot);
}
