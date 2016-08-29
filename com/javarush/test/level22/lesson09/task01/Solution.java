package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

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


        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.size();)
            {
                if(list.get(j).equals(new StringBuilder(list.get(i)).reverse().toString()) && j != i)
                {
                    Pair pair = new Pair();
                    pair.first = list.get(j);
                    pair.second = list.get(i);
                    result.add(pair);
                    list.remove(j);
                    list.remove(i);
                    j = 0;
                }
                else
                    j++;
            }
        }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
