package com.company.Workshop;

public class Toys {

    private String typeOfToy;

    public Toys(String typeOfToy) {
        this.typeOfToy = typeOfToy;
    }

    public void getBike(){
        typeOfToy = "bike";
        System.out.println("Getting bike");
    }

    public void getDoll(){
        typeOfToy = "doll";
        System.out.println("Getting doll");
    }
}
