package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution implements Serializable{
    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("d:/1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Person p = new Person("Oleg","Vail","qwe",Sex.MALE);
        outputStream.writeObject(p);
        System.out.println(p.country);
        System.out.println(p.firstName);
        System.out.println(p.lastName);
        System.out.println(p.fullName);
        System.out.println(p.greetingString);
        System.out.println(p.logger);
        System.out.println(p.sex);
        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("d:/1.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Person loadedObject = (Person) objectStream.readObject();
        System.out.println(loadedObject.country);
        System.out.println(loadedObject.firstName);
        System.out.println(loadedObject.lastName);
        System.out.println(loadedObject.fullName);
        System.out.println(loadedObject.greetingString);
        System.out.println(loadedObject.logger);
        System.out.println(loadedObject.sex);
        fiStream.close();
        objectStream.close();


    }
    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;



        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex implements Serializable {
        MALE,
        FEMALE
    }
}
