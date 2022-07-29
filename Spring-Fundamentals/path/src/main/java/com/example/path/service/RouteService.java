package com.example.path.service;

import com.example.path.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();
}
