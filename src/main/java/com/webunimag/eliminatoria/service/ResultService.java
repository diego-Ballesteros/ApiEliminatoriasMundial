package com.webunimag.eliminatoria.service;

import com.webunimag.eliminatoria.persistence.entity.ResultEntity;
import com.webunimag.eliminatoria.persistence.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    private final ResultRepository resultRepository;
    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public ResultEntity saveResult(ResultEntity result){
        return this.resultRepository.save(result);
    }

    public boolean existIdResult(int idResult){
        return this.resultRepository.existsById(idResult);
    }
}
