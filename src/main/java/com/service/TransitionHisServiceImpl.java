package com.service;


import com.domain.Route;
import com.domain.TransitionHis;
import com.repository.RouteRepository;
import com.repository.TransitionHisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransitionHisServiceImpl implements TransitionHisService{

    private TransitionHisRepository transitionHisRepository;

    public TransitionHisServiceImpl(TransitionHisRepository transitionHisRepository){
        this.transitionHisRepository=transitionHisRepository;
    }

    @Transactional(readOnly = true)
    public List<TransitionHis> getAll() {
        return transitionHisRepository.getAll();
    }

    @Transactional(readOnly = true)
    public TransitionHis get(Long transitionHis_id) {
        return transitionHisRepository.get(transitionHis_id);
    }

    @Transactional
    public TransitionHis create(TransitionHis transitionHis) {
        return transitionHisRepository.create(transitionHis);
    }

    @Transactional
    public TransitionHis update(TransitionHis transitionHis) {
        return transitionHisRepository.update(transitionHis);
    }

    @Transactional
    public void delete(Long transitionHis_id) {
        transitionHisRepository.delete(transitionHis_id);
    }
}
