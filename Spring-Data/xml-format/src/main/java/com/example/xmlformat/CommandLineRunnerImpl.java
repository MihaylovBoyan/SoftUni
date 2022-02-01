package com.example.xmlformat;

import com.example.xmlformat.model.dto.*;
import com.example.xmlformat.service.CategoryService;
import com.example.xmlformat.service.ProductService;
import com.example.xmlformat.service.UserService;
import com.example.xmlformat.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCES_FILE_PATH = "src/main/resources/files/";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/files/out/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String USERS_FILE_NAME = "users.xml";

    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;


    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {

        seedData();

        System.out.println("select ex:");
        int num = Integer.parseInt(bufferedReader.readLine());

        switch (num) {
            case 1:
                productsInRange();
            case 2:
                soldProducts();
        }


    }

    private void soldProducts() throws JAXBException {

        UserViewRootDto userViewRootDto =
                userService.findUsersWithMoreThanOneProduct();


        System.out.println();


        xmlParser.writeToFile(OUTPUT_FILE_PATH + "sold4.xml",
                userViewRootDto);
    }

    private void productsInRange() throws JAXBException {

        ProductViewRootDto productViewRootDto =
                productService.findInRange();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + "products.xml", productViewRootDto);

    }

    private void seedData() throws JAXBException, FileNotFoundException {

        if (categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME,
                    CategorySeedRootDto.class);
            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getUsersCount() == 0) {

            UserSeedRootDto userSeedRootDto = xmlParser
                    .fromFile(RESOURCES_FILE_PATH + USERS_FILE_NAME, UserSeedRootDto.class);


            userService.seedUsers(userSeedRootDto.getUsers());

        }

        if (productService.getCount() == 0) {

            ProductSeedRootDto productSeedRootDto =
                    xmlParser.fromFile(RESOURCES_FILE_PATH +
                            "products.xml", ProductSeedRootDto.class);

            productService.seedProducts(productSeedRootDto.getProducts());

        }

    }
}
