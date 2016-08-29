package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("1");
        words.add("2");
        words.add("3");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String file=bufferedReader.readLine();
        FileReader reader=new FileReader(file);
        String s="";
        String[] array;
        int count=0;
        while (reader.ready()){
            int c=reader.read();
            boolean t=reader.ready();

            if (!(c==13)) s=s+String.valueOf((char)c);

            if ((c==13)||(reader.ready()==false))
            {
              array=s.split(" ");
              for(int i=0;i<array.length;i++){
                  for (String word : words) {
                      if (word.equals(array[i].replace("\n",""))) count++;
                  }
              }if (count==2) System.out.println(s.replace("\n",""));
                s="";count=0;
            }

        }


    reader.close();
    }
}
