package com.example.mobi.service.impl;

import com.example.mobi.model.entity.ModelEntity;
import com.example.mobi.model.entity.OfferEntity;
import com.example.mobi.model.entity.UserEntity;
import com.example.mobi.model.entity.enums.EngineEnum;
import com.example.mobi.model.entity.enums.TransmissionEnum;
import com.example.mobi.model.service.OfferAddServiceModel;
import com.example.mobi.model.service.OfferUpdateServiceModel;
import com.example.mobi.model.view.OfferDetailsView;
import com.example.mobi.repository.ModelRepository;
import com.example.mobi.repository.OfferRepository;
import com.example.mobi.repository.UserRepository;
import com.example.mobi.service.OfferService;
import com.example.mobi.model.view.OfferSummaryView;
import com.example.mobi.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ModelMapper modelMapper, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    @Override
    public void initializeOffers() {

        if (offerRepository.count() == 0) {


            OfferEntity offer1 = new OfferEntity();

            offer1
                    .setDescription("top car you can bet on it, kachvash se i karash")
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                    .setEngine(EngineEnum.GASOLINE)
                    .setMileage(22500)
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setPrice(14300)
                    .setSeller(userRepository.findByUsername("pesho").orElse(null))
                    .setTransmission(TransmissionEnum.MANUAL)
                    .setYear(2019);

            OfferEntity offer2 = new OfferEntity();

            offer2
                    .setDescription("baba q e karala")
                    .setImageUrl("data:image/jpeg;base64,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")
                    .setEngine(EngineEnum.DIESEL)
                    .setMileage(209000)
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setPrice(5500)
                    .setYear(2000)
                    .setSeller(userRepository.findByUsername("pesho").orElse(null))
                    .setTransmission(TransmissionEnum.AUTOMATIC);

            offerRepository.saveAll(List.of(offer1, offer2));
        }


    }

    @Override
    public List<OfferSummaryView> getAllOffers() {

        return offerRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id) {

        OfferEntity offer = offerRepository.findById(id).orElse(null);

        OfferDetailsView offerDetailsView = modelMapper.map(offer, OfferDetailsView.class);
        offerDetailsView.setSeller(offer.getSeller());
        offerDetailsView.setModel(offer.getModel());

        return offerDetailsView;
    }

    @Override
    public void deleteOffer(Long id) {

        offerRepository.deleteById(id);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerModel) {
        OfferEntity offerEntity = offerRepository.findById(offerModel.getId()).orElseThrow(() -> new ObjectNotFoundException("Offer with id " + offerModel.getId() + " Not Found"));

        offerEntity.setPrice(offerModel.getPrice())
                .setDescription(offerModel.getDescription())
                .setEngine(offerModel.getEngine())
                .setImageUrl(offerModel.getImageUrl())
                .setMileage(offerModel.getMileage())
                .setTransmission(offerModel.getTransmission())
                .setYear(offerModel.getYear())
                .setModified(Instant.now());

        offerRepository.save(offerEntity);
    }

    @Override
    public void saveOffer(OfferAddServiceModel offerAddServiceModel, String ownerId) {

        OfferEntity offerEntity = modelMapper.map(offerAddServiceModel, OfferEntity.class);
        ModelEntity modelEntity = modelRepository.findByName(offerAddServiceModel.getModel()).orElse(null);
        offerEntity.setModel(modelEntity);
        offerEntity.setSeller(userRepository.findByUsername(ownerId).orElseThrow());


        offerRepository.save(offerEntity);


    }

    private OfferSummaryView map(OfferEntity offer) {
        OfferSummaryView summaryView = modelMapper.map(offer, OfferSummaryView.class);
        return summaryView.setModel(offer.getModel().getName());

    }

}
