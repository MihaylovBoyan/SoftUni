package com.example.mobi.service;

import com.example.mobi.model.service.OfferAddServiceModel;
import com.example.mobi.model.service.OfferUpdateServiceModel;
import com.example.mobi.model.view.OfferDetailsView;
import com.example.mobi.model.view.OfferSummaryView;

import java.security.Principal;
import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findById(Long id);

    void deleteOffer(Long id);

    void updateOffer(OfferUpdateServiceModel offerUpdateServiceModel);

    void saveOffer(OfferAddServiceModel offerAddServiceModel, String ownerId);
}
