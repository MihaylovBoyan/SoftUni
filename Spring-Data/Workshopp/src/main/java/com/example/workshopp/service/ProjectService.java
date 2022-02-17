package com.example.workshopp.service;

import com.example.workshopp.model.dto.ProjectDto;
import com.example.workshopp.model.entity.Project;

import java.io.IOException;

public interface ProjectService {

    String FILE_PATH = "files/xmls/projects.xml";


    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(ProjectDto request);

    Project find(Long id);

}
