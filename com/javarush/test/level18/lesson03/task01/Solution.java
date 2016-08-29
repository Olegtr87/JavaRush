package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        String file=read.readLine();
        FileInputStream inputStream=new FileInputStream(file);
        int tmp=0;
        while (inputStream.available()>0){
            int data=inputStream.read();

          if (data>tmp) tmp=data;
                    }
        inputStream.close();
        System.out.print(tmp);
    }
}
