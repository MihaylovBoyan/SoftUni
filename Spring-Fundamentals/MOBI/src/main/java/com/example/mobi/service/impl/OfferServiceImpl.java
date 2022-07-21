package com.example.mobi.service.impl;

import com.example.mobi.model.entity.OfferEntity;
import com.example.mobi.repository.OfferRepository;
import com.example.mobi.repository.UserRepository;
import com.example.mobi.service.OfferService;
import com.example.mobi.user.CurrentUser;
import com.example.mobi.view.OfferSummaryView;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeOffers() {

        if (offerRepository.count() == 0) {


            OfferEntity offer = new OfferEntity();

//            offer
//                    .setDescription("top car you can bet on it, kachvash se i karash")
//                    .setImageUrl()
//                    .setEngine()
//                    .setMileage()
//                    .setModel()
//                    .setPrice()
//                    .setSeller(user)
//                    .setTransmission(TransmissionEnum.MANUAL);
//
//            offerRepository.save(offer);
        }


    }

    @Override
    public List<OfferSummaryView> getAllOffers() {

        return offerRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private OfferSummaryView map(OfferEntity offer) {
       return modelMapper.map(offer, OfferSummaryView.class);
    }

}
