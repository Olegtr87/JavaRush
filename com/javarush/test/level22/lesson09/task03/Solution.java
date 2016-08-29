package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
         BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();
        reader.close();
        FileReader stream=new FileReader(file);
        String s="";
        LinkedList<String> list=new LinkedList<String>();
        while (stream.ready()){
            char i=(char)stream.read();
            if (String.valueOf(i).equals(" ")) {list.add(s);s="";} else s=s+(String.valueOf(i));

        }
        stream.close();
        list.add(String.valueOf(s));
        if (list.get(0).equals("")) list.remove(0);



        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
          return null;
    }
}
