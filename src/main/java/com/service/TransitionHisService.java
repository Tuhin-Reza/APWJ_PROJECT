package com.service;


import com.domain.TransitionHis;

import java.util.List;

public interface TransitionHisService {
    public List<TransitionHis> getAll();
    public TransitionHis get(Long transitionHis_id);
    public TransitionHis create(TransitionHis transitionHis);
    public TransitionHis update(TransitionHis transitionHis);
    public  void delete(Long transitionHis_id);

    public List<TransitionHis> getPerson(Long transitionHis_id);
}
