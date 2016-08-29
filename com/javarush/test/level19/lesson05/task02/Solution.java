package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   String world="world";
        BufferedReader readik = new BufferedReader(new InputStreamReader(System.in));
        String fileR = readik.readLine();
        FileInputStream reader1 = new FileInputStream(fileR);

        String ss="",ss1="";
        while (reader1.available()>0){
            int c=reader1.read();
            ss=ss+String.valueOf((char)c);
        }
        String line = ss.replaceAll("\\p{Punct}", " ").toLowerCase();


        String [] array=new String[line.length()];
        array=line.split(" ");
        int count=0;

        for (int i=0;i<array.length;i++){

            if (array[i].equalsIgnoreCase(world)) count++;
        }

        System.out.print(count);
        reader1.close();
    }
}
