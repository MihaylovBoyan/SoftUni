package com.example.path.service.impl;

import com.example.path.model.entity.Category;
import com.example.path.model.entity.Route;
import com.example.path.model.entity.User;
import com.example.path.model.service.RouteServiceModel;
import com.example.path.model.service.UserServiceModel;
import com.example.path.model.view.RouteDetailsViewModel;
import com.example.path.model.view.RouteViewModel;
import com.example.path.repository.RouteRepository;
import com.example.path.security.CurrentUser;
import com.example.path.service.CategoryService;
import com.example.path.service.RouteService;
import com.example.path.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
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

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {

        Route route = modelMapper.map(routeServiceModel, Route.class);
        route.setAuthor(userService.findCurrentUserLoggedUser());
        route.setCategories(routeServiceModel.getCategories().
                stream()
                .map(categoryService::findByName)
                .collect(Collectors.toSet()));

        routeRepository.save(route);


    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {

        return routeRepository.findById(id)
                .map(r -> modelMapper.map(r, RouteDetailsViewModel.class))
                .orElse(null);

    }
}
