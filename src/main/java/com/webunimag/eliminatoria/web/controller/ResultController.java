package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.persistence.entity.ResultEntity;
import com.webunimag.eliminatoria.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/resultados")
public class ResultController {

    private final ResultService resultService;
    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }
    @PostMapping
    public ResponseEntity<ResultEntity> addResult (@RequestBody ResultEntity result){
        if(result.getIdResult()==null || !this.resultService.existIdResult(result.getIdResult())){
            return ResponseEntity.ok(this.resultService.saveResult(result));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<ResultEntity> updateResult (@RequestBody ResultEntity result){
        if(result.getIdResult()!=null && this.resultService.existIdResult(result.getIdResult())){
            return ResponseEntity.ok(this.resultService.saveResult(result));
        }
        return ResponseEntity.badRequest().build();
    }
}
