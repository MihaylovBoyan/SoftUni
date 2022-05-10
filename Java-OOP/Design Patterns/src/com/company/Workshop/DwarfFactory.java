package com.company.Workshop;

public class DwarfFactory extends AbstractFactory {


    @Override
    public Dwarf getDwarf(String name) {
        System.out.println("new dwarf created " + name);
        return new Dwarf();
    }
}
