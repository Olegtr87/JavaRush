package com.javarush.test.level20.lesson04.task01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {
    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
    public static void main(String args[]) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Human ts = new Human();
        oos.writeObject(ts);
        fos.close();
        oos.close();
    }
}
