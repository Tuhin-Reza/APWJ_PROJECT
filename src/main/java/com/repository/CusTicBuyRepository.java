package com.repository;



import com.domain.CusTicBuy;

import java.util.List;

public interface CusTicBuyRepository {
    public List<CusTicBuy> getAll();
    public CusTicBuy get(Long cusTicBuy_id);
    public CusTicBuy create(CusTicBuy cusTicBuy);
    public CusTicBuy update(CusTicBuy cusTicBuy);
    public  void delete(Long cusTicBuy_id);

}
