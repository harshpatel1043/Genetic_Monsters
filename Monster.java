package org.java.introduction;

import java.io.*;

abstract class Monster implements Serializable {
    protected String name;
    protected String color;
    protected int strength;
    protected int speed;

    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    public abstract void performSpecialAbility();

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static Monster loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Monster) ois.readObject();
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Color: " + color + ", Strength: " + strength + ", Speed: " + speed;
    }
}

