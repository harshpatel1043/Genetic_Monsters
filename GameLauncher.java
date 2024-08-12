package org.java.introduction;

import org.java.introduction.MonsterManager;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameLauncher {
    private static final MonsterManager monsterManager = new MonsterManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("-----------------------");
            System.out.println("|Main Menu:          |");
            System.out.println("|1. Create Monster   |");
            System.out.println("|2. View Monsters    |");
            System.out.println("|3. Breed Monsters   |");
            System.out.println("|4. Save Game        |");
            System.out.println("|5. Load Game        |");
            System.out.println("|6. Exit             |");
            System.out.print("|Choose an option:   |");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    createMonster();
                    break;
                case 2:
                    viewMonsters();
                    break;
                case 3:
                    breedMonsters();
                    break;
                case 4:
                    saveGame();
                    break;
                case 5:
                    loadGame();
                    break;
                case 6:
                    exit = confirmExit();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createMonster() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter strength: ");
        int strength = scanner.nextInt();
        System.out.print("Enter speed: ");
        int speed = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Monster monster = new Monster(name, color, strength, speed) {
            @Override
            public void performSpecialAbility() {
                System.out.println(name + " has no special abilities yet.");
            }
        };
        monsterManager.addMonster(monster);
        System.out.println("Monster created: " + monster);
    }

    private static void viewMonsters() {
        System.out.println("Do you want a detailed view? (yes/no)");
        String detailedView = scanner.nextLine();
        boolean detailed = detailedView.equalsIgnoreCase("yes");
        monsterManager.displayMonsters(detailed);
    }

    private static void breedMonsters() {
        monsterManager.displayMonsters(false);
        System.out.print("Enter the index of the first monster: ");
        int index1 = scanner.nextInt();
        System.out.print("Enter the index of the second monster: ");
        int index2 = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        monsterManager.breedMonsters(index1, index2);
    }

    private static void saveGame() {
        try {
            monsterManager.saveGame("monsters_data.txt");
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save the game: " + e.getMessage());
        }
    }

    private static void loadGame() {
        try {
            monsterManager.loadGame("monsters_data.txt");
            System.out.println("Game loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load the game: " + e.getMessage());
        }
    }

    private static boolean confirmExit() {
        System.out.println("Do you want to exit without saving? (yes/no)");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }
}
