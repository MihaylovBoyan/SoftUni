package com.example.workshopp.service;

import com.example.workshopp.model.dto.EmployeeDto;
import com.example.workshopp.model.entity.Employee;
import com.example.workshopp.model.entity.Project;
import com.example.workshopp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectService projectService;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectService projectService, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.projectService = projectService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean exists() {
        return employeeRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(getClass()
                .getClassLoader()
                .getResourceAsStream(FILE_PATH)
                .readAllBytes());
    }

    @Override
    public Long create(EmployeeDto request) {

        Employee existing = employeeRepository.findFirstByFirstNameAndLastNameAndAge(
                request.getFirstName(),
                request.getLastName(),
                request.getAge()
        );

        if (existing != null) {
            return existing.getId();
        }

        var employee = modelMapper.map(request, Employee.class);
        Long projectId = projectService.create(request.getProject());
        Project project = projectService.find(projectId);

        employee.setProject(project);
        employeeRepository.save(employee);
        return employee.getId();

    }
}
