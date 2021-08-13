package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ShopSeedRootDto;
import exam.model.dto.TownsSeedRootDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;


    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(SHOPS_PATH, ShopSeedRootDto.class)
                .getShops()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto);
                    sb.append(isValid ? String.format("Successfully import Shop %s - %f", shopSeedDto.getName(),
                            shopSeedDto.getIncome())
                            : "Invalid Shop").append(System.lineSeparator());

                    return isValid;
                }).map(shopSeedDto -> modelMapper.map(shopSeedDto, Shop.class))
                .forEach(shopRepository::save);

        return sb.toString();


    }

    @Override
    public Shop findById(Long id) {
        return shopRepository.getById(id);
    }


}
