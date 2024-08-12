package org.java.introduction;


import java.io.IOException;
import java.util.ArrayList;

public class MonsterManager {
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    public void breedMonsters(int index1, int index2) {
        Monster parent1 = monsters.get(index1);
        Monster parent2 = monsters.get(index2);
        String name = "Offspring";
        String color = parent1.color;
        int strength = (parent1.strength + parent2.strength) / 2;
        int speed = (parent1.speed + parent2.speed) / 2;
        Monster offspring = new Monster(name, color, strength, speed) {
            @Override
            public void performSpecialAbility() {
                System.out.println(name + " has no special abilities yet.");
            }
        };
        monsters.add(offspring);
        System.out.println("New monster created: " + offspring);
    }

    public void saveGame(String filename) throws IOException, IOException {
        FileManager.saveMonsters(monsters, filename);
    }

    public void loadGame(String filename) throws IOException, ClassNotFoundException {
        monsters = FileManager.loadMonsters(filename);
    }

    public void displayMonsters(boolean detailed) {
        for (Monster m : monsters) {
            if (detailed) {
                System.out.println(m);
            } else {
                System.out.println(m.name);
            }
        }
    }
}
