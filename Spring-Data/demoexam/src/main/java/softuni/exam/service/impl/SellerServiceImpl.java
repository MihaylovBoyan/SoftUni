package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Seller;
import softuni.exam.models.dto.SellerDto;
import softuni.exam.models.dto.SellerRootDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String SELLER_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(SELLER_FILE_PATH, SellerRootDto.class)
                .getSellers()
                .stream()
                .filter(sellerDto -> {
                    boolean isValid = validationUtil.isValid(sellerDto);
                    appendText(isValid, sb, sellerDto);
                    return isValid;
                })
                .map(sellerDto -> modelMapper.map(sellerDto, Seller.class))
                .forEach(sellerRepository::save);

        return sb.toString();
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    private void appendText(boolean isValid, StringBuilder sb, SellerDto sellerDto) {
        if (isValid) {
            sb.append(String.format("Successfully import seller %s - %s%n", sellerDto.getLastName(), sellerDto.getEmail()));
        } else {
            sb.append(String.format("Invalid seller%n"));
        }
    }
}
