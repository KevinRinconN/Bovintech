package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthRecords;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.IBirthRepository;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CattleGetOngoingBirthUseCase {
    private final IBirthRepository iBirthRepository;
    private final CattleGetByIdDamUseCase cattleGetByIdDamUseCase;
    private final CattleGetByIdSireUseCase cattleGetByIdSireUseCase;

    public BirthRecords execute (Long idDam){
        int gestationPeriod = 280;

        Optional<BirthDto> birthDto = iBirthRepository.findByDamIdAndStatus(idDam, BirthStatus.EN_PROCESO);

        List<BirthDto> abortios = iBirthRepository.findByDamIdAndIsAbortion(idDam, true);

        Cattle cattle = cattleGetByIdDamUseCase.execute(idDam);
        List<BirthDto> BirthDates = iBirthRepository.findByDamIdOrderByBirthDateDesc(idDam);

        BirthRecords birtToShow = BirthRecords.builder()
                .offspring(cattle.getOffspring() != null || cattle.getOffspringDam() != null ? cattle.getOffspring().size() +  cattle.getOffspringDam().size() : 0)
                .abortions(abortios.size())
                .build();




        if(birthDto.isPresent()){
            Cattle cattleSire = cattleGetByIdSireUseCase.execute(birthDto.get().getSire().getId());

            String imgUrl =  CattleMapperDomain.INSTANCE.getLastWeightDetails(cattleSire.getRecords()).getImageUrl();

            birthDto.get().getSire().setLastWeightImage(imgUrl);
            birtToShow.setBirth(birthDto.get());
            birtToShow.setEstimatedDateBirth(birthDto.get().getInseminationDate().plusDays(gestationPeriod));
        }

        if (!BirthDates.isEmpty()){
            birtToShow.setLastBirth(BirthDates.get(0).getBirthDate());
        }

        return birtToShow;
    }
}
