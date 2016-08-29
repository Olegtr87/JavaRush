package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        FileInputStream inputStream1=new FileInputStream(file1);
        String file2=reader.readLine();
        FileOutputStream outputStream2=new FileOutputStream(file2);

        ArrayList<Integer> array=new ArrayList<Integer>();
        while (inputStream1.available()>0)
        {
            int byteReader=inputStream1.read();
            array.add(byteReader);
        }

        int tmp=0;

        for (int i=0;i<array.size()/2;i++){
           tmp=array.get(i);
           array.set(i,array.get(array.size()-1-i));
            array.set(array.size()-1-i,tmp);

        }

        for (int i=0;i<array.size();i++)
        {
            outputStream2.write(array.get(i));
        }

    inputStream1.close();
        outputStream2.close();
    }
}
