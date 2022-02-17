package com.example.workshopp.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class DataConverterImpl implements DataConverter {


    @Override
    public <T> T deserialize(String input, Class<T> type) throws JAXBException {


        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        var sr = new StringReader(input);

        return (T) unmarshaller.unmarshal(sr);

    }

    @Override
    public String serialize(Object o) {
        return o.toString();
    }
}
