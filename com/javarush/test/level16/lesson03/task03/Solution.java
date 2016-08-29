package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread spec=new SpecialThread();
        list.add(new Thread(spec));
        SpecialThread spec1=new SpecialThread();
        list.add(new Thread(spec1));
        SpecialThread spec2=new SpecialThread();
        list.add(new Thread(spec2));
        SpecialThread spec3=new SpecialThread();
        list.add(new Thread(spec3));
        SpecialThread spec4=new SpecialThread();
        list.add(new Thread(spec4));

    }

    public static class SpecialThread implements Runnable {
        public void run() {

            System.out.println("it's run method inside SpecialThread");
        }
    }
}
