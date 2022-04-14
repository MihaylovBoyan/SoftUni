package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Offer;
import softuni.exam.models.dto.OfferRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

       xmlParser.fromFile(OFFERS_FILE_PATH, OfferRootDto.class)
       .getOffers()
       .stream()
       .filter(offerDto -> {
           boolean isValid = validationUtil.isValid(offerDto);
           appendText(sb, offerDto, isValid);
           return isValid;
       })
       .map(offerDto -> {
           Offer offer = modelMapper.map(offerDto, Offer.class);
           offer.setCar(carService.findById(offerDto.getId().getId()));
           offer.setSeller(sellerService.findById(offerDto.getSellerId().getId()));
           return offer;
       })
       .forEach(offerRepository::save);



        return sb.toString();
    }

    private void appendText(StringBuilder sb, softuni.exam.models.dto.OfferDto offerDto, boolean isValid) {
        if (isValid) {
            sb.append(String.format("Successfully import offer %s - %s%n", offerDto.getAddedOn(), offerDto.isHasGoldStatus()));
        } else {
            sb.append(String.format("Invalid offer%n"));
        }
    }
}
