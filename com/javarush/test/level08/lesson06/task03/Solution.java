package com.javarush.test.level08.lesson06.task03;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Измерить сколько времени занимает 10 тысяч вставок для каждого списка
Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getTimeMsOfInsert  должен вернуть время его исполнения в миллисекундах.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getTimeMsOfInsert(new ArrayList()));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }

    public static long  getTimeMsOfInsert(List list)
    {
        //Напишите тут ваш код
        Date date=new Date();
        long s1=date.getTime();
        insert10000(list);
        Date date1=new Date();
        long s2=date1.getTime();
        long s3=s2-s1;
        //Напишите тут ваш код
        return s3;
    }

    public static void insert10000(List list)
    {
        for (int i=0;i<10000;i++)
        {
            list.add(0, new Object());
        }
    }
}
