package com.example.workshopp.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectCollectionDto {

    @XmlElement(name = "projects")
    private List<ProjectDto> projects;

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public ProjectCollectionDto setProjects(List<ProjectDto> projects) {
        this.projects = projects;
        return this;
    }
}
