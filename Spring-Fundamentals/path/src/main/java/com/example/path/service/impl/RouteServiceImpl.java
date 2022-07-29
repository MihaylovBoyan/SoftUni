package com.example.path.service.impl;

import com.example.path.model.view.RouteViewModel;
import com.example.path.repository.RouteRepository;
import com.example.path.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<RouteViewModel> findAllRoutesView() {

        return routeRepository.findAll()
                .stream()
                .map(r -> {
                    RouteViewModel routeViewModel = modelMapper.map(r, RouteViewModel.class);
                    routeViewModel.setPictureUrl(r.getPictures().isEmpty() ? "/images/pic4.jpg" : r.getPictures().stream().findFirst().get().getUrl());
                            return routeViewModel;
                }).collect(Collectors.toList());

    }
}
