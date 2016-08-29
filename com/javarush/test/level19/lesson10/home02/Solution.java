package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        double max=0.0;

        for(Map.Entry<String,Double> e : map.entrySet()){

            if (e.getValue()>max) max=e.getValue();
        }
        for(Map.Entry<String,Double> e : map.entrySet()){

            if (e.getValue()==max) System.out.println(e.getKey());
        }
    }
}
