package com.example.mobi.service;

import com.example.mobi.view.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();
}
