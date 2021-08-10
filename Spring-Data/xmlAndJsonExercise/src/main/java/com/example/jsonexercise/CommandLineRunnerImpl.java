package com.example.jsonexercise;

import com.example.jsonexercise.model.dto.*;
import com.example.jsonexercise.service.CategoryService;
import com.example.jsonexercise.service.ProductService;
import com.example.jsonexercise.service.UserService;
import com.example.jsonexercise.util.XmlParser;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCES_FILE_PATH = "src/main/resources/files/";
    private static final String OUT_PATH = "src/main/resources/files/out/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String OUTPUT_PATH = "src/main/resources/files/out/";
    private static final String PRODUCT_IN_RANGE_FILE_NAME = "products-in-range.json";
    private static final String USERS_AND_SOLD_PRODUCTS = "users-and-sold-products.json";
    private static final String USERS_FILE_NAME = "users.xml";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;
    private final XmlParser xmlParser;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson, XmlParser xmlParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.xmlParser = xmlParser;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();


    }

    private void seedData() throws JAXBException, IOException {
//        if (categoryService.getEntityCount() == 0) {
//            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME,
//                    CategorySeedRootDto.class);
//
//            categoryService.seedCategoriesXml(categorySeedRootDto.getCategories());
//        }


        System.out.println("Select ex.");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum){
            case 1:
                productsInRange();
                break;
            case 2:
                usersWithSoldProducts();
        }

    }

    private void usersWithSoldProducts() throws JAXBException {

        UserViewRootDto userViewRootDto = userService
                .findAllUsersWithMoreThanOneSoldProductss();

        xmlParser.writeToFile(OUTPUT_PATH + "sold.xml",
                userViewRootDto);

    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto rootDto = productService
                .findProductInRangeWithoutBuyer();

            xmlParser.writeToFile(OUTPUT_PATH + "shit.xml",
                    rootDto);

    }
}
