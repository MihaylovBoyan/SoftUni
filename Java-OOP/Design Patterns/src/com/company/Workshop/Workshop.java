package com.company.Workshop;

import java.util.ArrayList;
import java.util.List;

public class Workshop {

    private List<Observer> dwarfs;

    public Workshop() {
        this.dwarfs = new ArrayList<>();
    }

    public Workshop setDwarfs(List<Observer> dwarfs) {
        this.dwarfs = dwarfs;
        return this;
    }



}
