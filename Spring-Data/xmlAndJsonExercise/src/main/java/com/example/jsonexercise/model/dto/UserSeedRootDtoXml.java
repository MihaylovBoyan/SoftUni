package com.example.jsonexercise.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class UserSeedRootDtoXml {

    private List<UserSeedDtoXml> users;

    @XmlElement(name = "user")
    public List<UserSeedDtoXml> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeedDtoXml> users) {
        this.users = users;
    }
}
