package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Администратор on 16.06.15.
 */
public class Hippodrome

{   private static ArrayList<Horse> horses=new ArrayList<Horse>();

    public static Hippodrome game;
    public static void main(String[] array) throws InterruptedException
    {
        game=new Hippodrome();
        Horse vasya=new Horse("Vasya",3,0);
        Horse vanya=new Horse("Vanya",3,0);
        Horse kolya=new Horse("Kolya",3,0);

        game.horses.add(vasya);
        game.horses.add(vanya);
        game.horses.add(kolya);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses(){
        return horses;
    }
    public void move(){
    for (Horse horse:horses){
        horse.move();
    }

    }
    public void run() throws InterruptedException
    {
        for (int i=0;i<100;i++){
            move();
            print();

            Thread.sleep(500);

        }
    }
    public void print(){
        for (Horse horse:horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        double max=0;
        Horse h=null;
        for (Horse horse:horses){
            if (horse.getDistance()>max) {max=horse.getDistance();h=horse;}

        }
        return h;
    }
    public void printWinner(){

        System.out.println("Winner is "+getWinner().getName()+"!");
    }

}
