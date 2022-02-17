package com.example.workshopp.service;

import com.example.workshopp.model.dto.ProjectDto;
import com.example.workshopp.model.entity.Company;
import com.example.workshopp.model.entity.Project;
import com.example.workshopp.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final CompanyService companyService;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper, CompanyService companyService) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.companyService = companyService;
    }

    @Override
    public boolean exists() {
        return projectRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(getClass()
                .getClassLoader()
                .getResourceAsStream(FILE_PATH)
                .readAllBytes());
    }



    @Override
    public Long create(ProjectDto request) {

        Project existing = projectRepository.findFirstByNameAndCompanyName(request.getName(),
                request.getCompany().getName());

        if (existing != null) {
            return existing.getId();
        }

        Long companyId = companyService.create(request.getCompany());

        Company company = companyService.find(companyId);
        Project project = modelMapper.map(request, Project.class);
        project.setCompany(company);

        projectRepository.save(project);
        return project.getId();
    }

    @Override
    public Project find(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }
}
