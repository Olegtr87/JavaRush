package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
    String file1=args[0];
        String file2=args[1];
        FileReader reader=new FileReader(file1);
        FileWriter writer=new FileWriter(file2);
        String s="";
        ArrayList<String> array=new ArrayList<String>();
        while (reader.ready()){
            int c=reader.read();
            if (!(c==32)&&!(c==13)) s=s+String.valueOf((char)c); else
                if (s.length()>6) {array.add(s);array.add(",");s="";
                } else if (s.length()<=6) s="";

        }
        if (s.length()>6) {array.add(s);array.add(",");}


        for (int i=0;i<array.size()-1;i++){
            writer.write(array.get(i).replace("\n",""));
        }
        reader.close();
        writer.close();
    }
}
