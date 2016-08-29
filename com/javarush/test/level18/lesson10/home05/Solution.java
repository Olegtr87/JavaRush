package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        FileReader readerFile=new FileReader(file1);
        FileWriter writer=new FileWriter(file2);

        String s="";
        ArrayList<String> array=new ArrayList<String>();
        while (readerFile.ready()){
            int c=readerFile.read();
            if (!(c==32)) s=s+String.valueOf((char)c); else
            {array.add(s);s=""; }

        }array.add(s);
        for (int i=0;i<array.size();i++){
            writer.write(String.valueOf(Math.round(Double.valueOf(array.get(i))))+" ");
        }
        readerFile.close();
        writer.close();
    }
}
