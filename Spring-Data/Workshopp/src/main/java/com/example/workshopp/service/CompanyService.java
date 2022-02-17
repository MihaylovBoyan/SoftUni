package com.example.workshopp.service;


import com.example.workshopp.model.dto.CompanyDto;
import com.example.workshopp.model.entity.Company;

import java.io.IOException;

public interface CompanyService {

    String FILE_PATH = "files/xmls/companies.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(CompanyDto request);

    Company find(Long id);
}
