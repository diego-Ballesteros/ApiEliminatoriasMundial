package com.webunimag.eliminatoria.dto.mapper;

import com.webunimag.eliminatoria.dto.dto.ResultDto;
import com.webunimag.eliminatoria.persistence.entity.ResultEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultMapper {
    ResultDto resultEntityToResultDto (ResultEntity result);
    ResultEntity resultDtoToResultEntity (ResultDto resultDto);
}
