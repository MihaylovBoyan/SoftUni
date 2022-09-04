package com.example.path.service;

import com.example.path.model.service.RouteServiceModel;
import com.example.path.model.view.RouteDetailsViewModel;
import com.example.path.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);
}
