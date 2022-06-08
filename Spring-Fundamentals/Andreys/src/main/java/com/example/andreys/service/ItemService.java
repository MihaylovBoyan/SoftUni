package com.example.andreys.service;

import com.example.andreys.model.service.ItemServiceModel;
import com.example.andreys.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(Long id);

    void delete(Long id);
}
