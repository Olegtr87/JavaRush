package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        FileReader reader=new FileReader(bufferedReader.readLine());
        String s="";
        ArrayList<String> array=new ArrayList<String>();
        while (reader.ready()){
            int c=reader.read();
            if (!(c==13)) s=String.valueOf((char)c)+s; else {array.add(s.replace("\n",""));s="";}
        }array.add(s.replace("\n",""));

        for (int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }


    }
}
