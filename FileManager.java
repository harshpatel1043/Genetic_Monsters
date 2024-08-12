package org.java.introduction;

import java.io.*;
import java.util.ArrayList;

class FileManager {

    public static void saveMonsters(ArrayList<Monster> monsters, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(monsters);
        }
    }

    public static ArrayList<Monster> loadMonsters(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<Monster>) ois.readObject();
        }
    }
}

