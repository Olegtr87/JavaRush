package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException
    {



        int count=0;
        FileInputStream stream=new FileInputStream(args[0]);
        while (stream.available()>0){
            int c=stream.read();
            if ((c>64&&c<91)||(c>96&&c<123)) count++;

        }
        stream.close();
        System.out.println(count);

    }
}
