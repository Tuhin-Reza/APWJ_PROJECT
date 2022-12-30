package com.service;


import com.domain.Route;
import com.repository.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RouteServiceImpl implements RouteService{
    private RouteRepository routeRepository;
    public RouteServiceImpl(RouteRepository routeRepository){
        this.routeRepository=routeRepository;
    }
    @Transactional(readOnly = true)
    public List<Route> getAll() {
        return routeRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Route get(Long route_id) {
        return routeRepository.get(route_id);
    }

    @Transactional
    public Route create(Route route) {
        return routeRepository.create(route);
    }

    @Transactional
    public Route update(Route route) {
        return routeRepository.update(route);
    }

    @Transactional
    public void delete(Long route_id) {
        routeRepository.delete(route_id);
    }
}
