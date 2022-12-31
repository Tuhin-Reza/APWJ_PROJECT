package com.service;


import com.domain.CusTicBuy;
import com.repository.CusTicBuyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CusTicBuyServiceImpl implements  CusTicBuyService{

    private CusTicBuyRepository cusTicBuyRepository;
    public  CusTicBuyServiceImpl(CusTicBuyRepository cusTicBuyRepository){

        this.cusTicBuyRepository=cusTicBuyRepository;
    }
    @Transactional(readOnly = true)
    public List<CusTicBuy> getAll() {
        return cusTicBuyRepository.getAll();
    }

    @Transactional(readOnly = true)
    public CusTicBuy get(Long cusTicBuy_id) {
        return cusTicBuyRepository.get(cusTicBuy_id);
    }

    @Transactional
    public  CusTicBuy create(CusTicBuy account) {
        return cusTicBuyRepository.create(account);
    }

    @Transactional
    public  CusTicBuy update(CusTicBuy cusTicBuy) {
        return cusTicBuyRepository.update(cusTicBuy);
    }

    @Transactional
    public void delete(Long cusTicBuy_id) {
        cusTicBuyRepository.delete(cusTicBuy_id);
    }
}
