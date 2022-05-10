package com.company;
import com.company.Workshop.*;
import com.company.Workshop.Command;



import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Workshop workshop = new Workshop();
        MagicBoard magicBoard = new MagicBoard();

        AbstractFactory dwarfFactory = com.company.Workshop.FactoryProducer.getFactory("dwarf");
        Observer gogo = dwarfFactory.getDwarf("gogo").setMagicBoard(magicBoard);
        Observer togo = dwarfFactory.getDwarf("togo").setMagicBoard(magicBoard);
        Observer bogo = dwarfFactory.getDwarf("bogo").setMagicBoard(magicBoard);

        workshop.setDwarfs(Arrays.asList(gogo,togo,bogo));

        magicBoard.subscribe(gogo);
        magicBoard.subscribe(togo);
        magicBoard.subscribe(bogo);

        String magicWords = scanner.nextLine();
        Toys toys = new Toys(magicWords);
        Santa santa = new Santa();
        santaMakesOrder(magicWords, toys, santa);

        while (magicWords.equals("doll") || magicWords.equals("bike")) {

            magicBoard.setMagicWords(magicWords);
            magicBoard.createToy().makeToy();
            magicWords = scanner.nextLine();
            santaMakesOrder(magicWords, toys, santa);
        }

        System.out.println();
    }

    private static void santaMakesOrder(String magicWords, Toys toys, Santa santa) {
        if (magicWords.equals("bike")) {
            BikesCommand bikesCommand = new BikesCommand(toys);
            santa.setCommand(bikesCommand);
            santa.makeOrder();
        } else if (magicWords.equals("doll")) {
            Command dollsCommand = new DollsCommand(toys);
            santa.setCommand(dollsCommand);
            santa.makeOrder();
        }
    }
}
