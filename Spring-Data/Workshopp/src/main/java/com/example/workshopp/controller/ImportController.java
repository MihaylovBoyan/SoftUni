package com.example.workshopp.controller;

import com.example.workshopp.model.dto.CompanyCollectionDto;
import com.example.workshopp.model.dto.ImportCompaniesDto;
import com.example.workshopp.service.CompanyService;
import com.example.workshopp.service.EmployeeService;
import com.example.workshopp.service.ProjectService;
import com.example.workshopp.util.DataConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class ImportController extends BaseController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;
    private final DataConverter converter;

    public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService, DataConverter converter) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.converter = converter;
    }

    @GetMapping("/import/xml")
    public String importXml(HttpServletRequest request, Model model) {

        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("areImported", new boolean[]{companyService.exists(),
                projectService.exists(), employeeService.exists()});

        return "xml/import-xml";
    }


    @GetMapping("/import/companies")
    public String importCompanies(Model model, HttpServletRequest request) throws IOException {

        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("companies",
                companyService.getXmlForImport());

        return "xml/import-companies";
    }

    @PostMapping("/import/companies")
    public String importCompanies(ImportCompaniesDto request) throws JAXBException {
        var companyRoot =
                converter.deserialize(request.getCompanies(),
                        CompanyCollectionDto.class);

        companyRoot.getCompanies().forEach(companyService::create);
        return "redirect:/xml/import-xml";
    }


    @GetMapping("/import/projects")
    public String importProjects(Model model, HttpServletRequest request) throws IOException {

        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("projects",
                projectService.getXmlForImport());

        return "xml/import-projects";
    }

    @PostMapping("/import/projects")
    public String importProjects(ImportCompaniesDto request) throws JAXBException {
        var companyRoot =
                converter.deserialize(request.getCompanies(),
                        CompanyCollectionDto.class);

        companyRoot.getCompanies().forEach(companyService::create);
        return "redirect:/xml/import-xml";
    }

    @GetMapping("/import/employees")
    public String importEmployees(Model model, HttpServletRequest request) throws IOException {

        if (!this.isLogged(request)) {
            return "redirect:/";
        }
        model.addAttribute("employees",
                employeeService.getXmlForImport());

        return "xml/import-employees";
    }


}
