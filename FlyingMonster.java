package org.java.introduction;

import java.io.IOException;

class FlyingMonster extends Monster {
    private int wingSpan;

    public FlyingMonster(String name, String color, int strength, int speed, int wingSpan) {
        super(name, color, strength, speed);
        this.wingSpan = wingSpan;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is flying with a wingspan of " + wingSpan + " meters!");
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        super.saveToFile(filename);
    }

    @Override
    public String toString() {
        return super.toString() + ", WingSpan: " + wingSpan;
    }
}

class AquaticMonster extends Monster {
    private int swimSpeed;

    public AquaticMonster(String name, String color, int strength, int speed, int swimSpeed) {
        super(name, color, strength, speed);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is swimming at " + swimSpeed + " km/h!");
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        super.saveToFile(filename);
    }

    @Override
    public String toString() {
        return super.toString() + ", SwimSpeed: " + swimSpeed;
    }
}

// Similarly, you can create the MountainMonster and DesertMonster classes.
