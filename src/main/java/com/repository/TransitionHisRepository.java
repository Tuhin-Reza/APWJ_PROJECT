package com.repository;

import com.domain.TransitionHis;
import java.util.List;

public interface TransitionHisRepository {
    public List<TransitionHis> getAll();
    public TransitionHis get(Long transitionHis_id);
    public TransitionHis create(TransitionHis transitionHis);
    public TransitionHis update(TransitionHis transitionHis);
    public  void delete(Long transitionHis_id);
    public List<TransitionHis> getPerson(Long transitionHis_id);

}
