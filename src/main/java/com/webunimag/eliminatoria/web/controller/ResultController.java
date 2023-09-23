package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.dto.dto.ResultDto;
import com.webunimag.eliminatoria.dto.mapper.ResultMapper;
import com.webunimag.eliminatoria.persistence.entity.ResultEntity;
import com.webunimag.eliminatoria.service.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/resultados")
public class ResultController {

    private final ResultService resultService;
    private final ResultMapper resultMapper;
    @Autowired
    public ResultController(ResultService resultService, ResultMapper resultMapper) {
        this.resultService = resultService;
        this.resultMapper = resultMapper;
    }
    @PostMapping
    public ResponseEntity<ResultDto> addResult (@RequestBody @Valid ResultEntity result){
        if(result.getIdResult()==null || !this.resultService.existIdResult(result.getIdResult())){
            ResultEntity resultCreated = this.resultService.saveResult(result);
            ResultDto resultDto =   this.resultMapper.resultEntityToResultDto(resultCreated);
            return ResponseEntity.ok(resultDto);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<ResultDto> updateResult (@RequestBody @Valid ResultEntity result){
        if(result.getIdResult()!=null && this.resultService.existIdResult(result.getIdResult())){
            ResultEntity resultCreated = this.resultService.saveResult(result);
            ResultDto resultDto =   this.resultMapper.resultEntityToResultDto(resultCreated);
            return ResponseEntity.ok(resultDto);
        }
        return ResponseEntity.badRequest().build();
    }
}
