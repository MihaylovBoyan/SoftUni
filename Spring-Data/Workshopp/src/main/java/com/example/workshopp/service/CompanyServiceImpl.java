package com.example.workshopp.service;

import com.example.workshopp.model.dto.CompanyDto;
import com.example.workshopp.model.entity.Company;
import com.example.workshopp.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }


    @Override
    public boolean exists() {
        return companyRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(getClass()
                .getClassLoader()
                .getResourceAsStream(FILE_PATH)
                .readAllBytes());
    }

    @Override
    public Long create(CompanyDto request) {


        Company existing = companyRepository.findFirstByName(request.getName());
        if (existing != null) {
            return existing.getId();
        }

        Company company = modelMapper.map(request, Company.class);
        companyRepository.save(company);

        return company.getId();
    }

    @Override
    public Company find(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }
}
