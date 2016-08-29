package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readik=new BufferedReader(new InputStreamReader(System.in));
        String fileR=readik.readLine();
        String fileW=readik.readLine();
        FileReader reader=new FileReader(fileR);
        FileWriter writer=new FileWriter(fileW);
        String s="";

        while (reader.ready()){
            int c=reader.read();
            s= String.valueOf((char)c);
            if (s.equals(".")) s="!";
            writer.write(s);

        }

reader.close();
        writer.close();



    }
}
