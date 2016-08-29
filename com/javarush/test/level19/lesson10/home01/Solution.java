package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
    String s=args[0];
    FileReader reader=new FileReader(s);
    ArrayList<String> array=new ArrayList<String>();
        String str="";

        while (reader.ready()){
            int c=reader.read();
            if (c!=13) {str=str+String.valueOf((char)c);} else
            {
                array.add(str);str="";
            }
     }  array.add(str);
        String[] ss=new String[2];
        TreeMap<String,Double> map=new TreeMap<String,Double>();
        for (int i=0;i<array.size();i++){
            array.set(i, array.get(i).replace("\n", ""));
            ss=array.get(i).split(" ");
            if (!map.containsKey(ss[0])) map.put(ss[0], Double.valueOf(ss[1]));

            else {double val = map.get(ss[0]) + Double.valueOf(ss[1]);
                 map.put(ss[0], val);}
        }

        for(Map.Entry e : map.entrySet()){

            System.out.println(e.getKey()+" "+ e.getValue());
        }




    }
}
