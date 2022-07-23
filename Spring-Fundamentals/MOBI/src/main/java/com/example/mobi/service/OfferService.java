package com.example.mobi.service;

import com.example.mobi.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();
}
