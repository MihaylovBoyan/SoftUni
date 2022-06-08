package com.example.andreys.service.impl;

import com.example.andreys.model.entity.Item;
import com.example.andreys.model.service.CategoryServiceModel;
import com.example.andreys.model.service.ItemServiceModel;
import com.example.andreys.model.view.ItemViewModel;
import com.example.andreys.repository.ItemRepository;
import com.example.andreys.service.CategoryService;
import com.example.andreys.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        Item item = modelMapper.map(itemServiceModel, Item.class);
        item.setCategory(categoryService.findByCategoryName(itemServiceModel.getCategory().getName()));
        itemRepository.save(item);

    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImageUrl(String.format("/img/%s-%s.jpg", item.getGender().name(),
                            item.getCategory().getName()));
                    return itemViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImageUrl(String.format("/img/%s-%s.jpg", item.getGender().name(),
                            item.getCategory().getName()));
                    return itemViewModel;
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
