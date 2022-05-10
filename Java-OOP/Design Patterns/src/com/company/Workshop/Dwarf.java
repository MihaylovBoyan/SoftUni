package com.company.Workshop;

public class Dwarf implements Observer {

    private String name;
    private String magicWords;
    private Subject magicBoard;

    @Override
    public void update() {

        if(magicBoard == null){
            System.out.println("no words from Santa");
            return;
        }

        String update = magicBoard.getUpdate();
        System.out.printf("Taking toy %s %n", update);
    }

    @Override
    public void setMagicWords(String magicWords) {
        this.magicWords = magicWords;
    }

    public Dwarf setMagicBoard(Subject magicBoard) {
        this.magicBoard = magicBoard;
        return this;
    }


    public String getName() {
        return name;
    }

    public Dwarf setName(String name) {
        this.name = name;
        return this;
    }
}
