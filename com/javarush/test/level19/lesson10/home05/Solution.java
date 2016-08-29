package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.FileNotFoundException;
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
            if (!(c==32)) s=s+String.valueOf((char)c); else {array.add(s);s="";}
        }array.add(s);

        for (int i=0;i<array.size();i++){
            if (array.get(i).matches(".*[0-9].*")) writer.write(array.get(i)+" ");
        }
        reader.close();
        writer.close();

    }
}
