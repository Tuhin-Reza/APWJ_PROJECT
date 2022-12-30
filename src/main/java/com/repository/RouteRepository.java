package com.repository;

import com.domain.Route;
import com.domain.User;

import java.util.List;

public interface RouteRepository {
    public List<Route> getAll();
    public Route get(Long route_id);
    public Route create(Route route);
    public Route update(Route route);
    public  void delete(Long route_id);

}
