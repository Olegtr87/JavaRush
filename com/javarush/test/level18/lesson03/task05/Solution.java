package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();
        FileInputStream inputStream=new FileInputStream(file);
        ArrayList<Integer> array=new ArrayList<Integer>();
        while (inputStream.available()>0){
            int data=inputStream.read();
            array.add(data);

        }

        inputStream.close();

        for(int i=0;i<array.size();i++){
            for(int j=i+1;j<array.size();j++){
                if (array.get(i)==array.get(j)) {array.remove(j);j--;}
            }
        }

        Collections.sort(array);
        for(int i=0;i<array.size();i++){
        System.out.print(array.get(i)+" ");}
    }
}
