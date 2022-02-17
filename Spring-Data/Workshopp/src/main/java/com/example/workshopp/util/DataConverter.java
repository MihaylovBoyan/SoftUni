package com.example.workshopp.util;

import javax.xml.bind.JAXBException;

public interface DataConverter {


    <T> T deserialize(String input, Class<T> type) throws JAXBException;

     String serialize(Object o);

}
