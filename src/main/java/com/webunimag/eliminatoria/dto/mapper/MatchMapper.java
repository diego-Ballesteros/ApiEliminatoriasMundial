package com.webunimag.eliminatoria.dto.mapper;

import com.webunimag.eliminatoria.dto.dto.MatchDto;
import com.webunimag.eliminatoria.persistence.entity.MatchEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchDto matchEntityToMatchDto (MatchEntity match);
    MatchEntity matchDtoToMatchEntity(MatchDto matchDto);
}
