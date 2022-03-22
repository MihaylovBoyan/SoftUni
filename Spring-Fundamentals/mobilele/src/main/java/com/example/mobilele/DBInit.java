package com.example.mobilele;

import com.example.mobilele.model.entity.*;
import com.example.mobilele.model.entity.enums.Category;
import com.example.mobilele.model.entity.enums.Engine;
import com.example.mobilele.model.entity.enums.Role;
import com.example.mobilele.model.entity.enums.Transmission;
import com.example.mobilele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public DBInit(BrandRepository brandRepository, ModelRepository modelRepository, OfferRepository offerRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Brand fordBrand = new Brand();
        fordBrand.setName("Ford");
        setCurrentTimeStamps(fordBrand);


        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");
        setCurrentTimeStamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        Model fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initUsers();

    }

    private void initUsers() {

        UserRole userRole = new UserRole().setName(Role.USER);
        UserRole adminRole = new UserRole().setName(Role.ADMIN);

        userRoleRepository.saveAll(List.of(userRole, adminRole));

        User admin = new User();
        admin
                .setFirstName("Петър")
                .setLastName("Димитров")
                .setUsername("admin")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setUserRoles(List.of(userRole, adminRole));
        setCurrentTimeStamps(admin);

        User pesho = new User();

        pesho
                .setUsername("Петър")
                .setLastName("Иванов")
                .setUsername("pesho")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setUserRoles(List.of(userRole));
        setCurrentTimeStamps(pesho);

        userRepository.saveAll(List.of(admin, pesho));

    }

    private void createFiestaOffer(Model model) {

        Offer fiestaOffer = new Offer();

        fiestaOffer
                .setEngine(Engine.GASOLINE)
                .setImageUrl("https://www.ford.co.uk/content/dam/guxeu/rhd/central/cars/2021-fiesta/future-vehicle/billboards/ford-fiesta-eu-B479_STline-eu-STL-01_L_21x9-2160x925-nameplateBB.jpg.renditions.original.png")
                .setMileage(40000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("Karana e ot nemska baba. Zimata v garaj.")
                .setTransmission(Transmission.MANUAL)
                .setModel(model);

        setCurrentTimeStamps(fiestaOffer);
        offerRepository.save(fiestaOffer);

    }

    private Model initNC750S(Brand hondaBrand) {
        Model nc750S = new Model();
        nc750S.setName("NC750S")
                .setCategory(Category.MOTORCYCLE)
                .setImageUrl("https://image.bikebros.co.jp/bike_img/1/13463/1_l.jpg")
                .setStartYear(2014)
                .setBrand(hondaBrand);

        setCurrentTimeStamps(nc750S);

        return modelRepository.save(nc750S);

    }

    private Model initEscort(Brand fordBrand) {

        Model escort = new Model();
        escort.setName("Escort")
                .setCategory(Category.CAR)
                .setImageUrl("https://silodrome.com/wp-content/uploads/2021/12/Ford-Escort-Mk2-7.jpg")
                .setStartYear(1968)
                .setEndYear(2002)
                .setBrand(fordBrand);

        setCurrentTimeStamps(escort);

        return modelRepository.save(escort);

    }

    private Model initFiesta(Brand fordBrand) {

        Model fiesta = new Model();
        fiesta.setName("Fiesta")
                .setCategory(Category.CAR)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setStartYear(1976)
                .setBrand(fordBrand);

        setCurrentTimeStamps(fiesta);

        return modelRepository.save(fiesta);

    }

    private static void setCurrentTimeStamps(BaseEntity brand) {
        brand.setCreated(Instant.now()).setModified(Instant.now());
    }
}
