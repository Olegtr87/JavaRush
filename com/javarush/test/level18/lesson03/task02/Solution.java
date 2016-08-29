package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();
        FileInputStream inputStream=new FileInputStream(file);
        int tmp=inputStream.read();

        while (inputStream.available()>0){
            int data=inputStream.read();

            if (data<tmp) tmp=data;

        }
        inputStream.close();
        System.out.print(tmp);
    }
}
