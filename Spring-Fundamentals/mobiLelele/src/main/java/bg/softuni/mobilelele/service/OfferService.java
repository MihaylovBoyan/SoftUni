package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.view.OfferSummaryView;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

}
