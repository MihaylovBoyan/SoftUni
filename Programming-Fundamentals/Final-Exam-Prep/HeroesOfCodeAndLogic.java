package FinalExamPreparation;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String[] heroInfo = scanner.nextLine().split("\\s+");

            String name = heroInfo[0];
            int hp = Integer.parseInt(heroInfo[1]);
            int mana = Integer.parseInt(heroInfo[2]);

            heroes.put(name, new ArrayList<>());
            heroes.get(name).add(hp);
            heroes.get(name).add(mana);


        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split(" - ");

            String action = tokens[0];

            if (action.equals("CastSpell")) {

                String heroName = tokens[1];
                int mpNeeded = Integer.parseInt(tokens[2]);
                String spellName = tokens[3];

                if (heroes.get(heroName).get(1) >= mpNeeded) {

                    heroes.get(heroName).set(1, heroes.get(heroName).get(1) - mpNeeded);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName).get(1));

                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }


            } else if (action.equals("TakeDamage")) {

                String heroName = tokens[1];
                int damage = Integer.parseInt(tokens[2]);
                String attacker = tokens[3];

                heroes.get(heroName).set(0, heroes.get(heroName).get(0) - damage);
                if (heroes.get(heroName).get(0) > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroes.get(heroName).get(0));
                } else {
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    heroes.remove(heroName);
                }


            } else if (action.equals("Recharge")) {

                String heroName = tokens[1];
                int amount = Integer.parseInt(tokens[2]);
                int currentMana = heroes.get(heroName).get(1);

                if (amount + currentMana <= 200) {
                    heroes.get(heroName).set(1, amount + currentMana);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                } else {
                    heroes.get(heroName).set(1, 200);
                    System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentMana);

                }


            } else if (action.equals("Heal")) {

                String heroName = tokens[1];
                int amount = Integer.parseInt(tokens[2]);

                int currentHealth = heroes.get(heroName).get(0);

                if (amount + currentHealth <= 100) {
                    heroes.get(heroName).set(0, amount + currentHealth);
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                } else {
                    heroes.get(heroName).set(0, 100);
                    System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHealth);

                }

            }


            command = scanner.nextLine();
        }


        heroes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((e, e1) -> e1.getValue().get(0).compareTo(e.getValue().get(0)))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("  " + "HP: " + e.getValue().get(0));
                    System.out.println("  " + "MP: " + e.getValue().get(1));
                });


    }
}
