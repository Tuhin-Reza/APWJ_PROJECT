package com.service;

import com.domain.Route;

import java.util.List;

public interface RouteService {
    public List<Route> getAll();
    public Route get(Long route_id);
    public Route create(Route route);
    public Route update(Route route);
    public  void delete(Long route_id);
}
