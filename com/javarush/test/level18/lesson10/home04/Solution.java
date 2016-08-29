package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1=new BufferedReader(new InputStreamReader(System.in));
        String put1=reader1.readLine();
        String put2=reader1.readLine();

        FileInputStream streamRead1=new FileInputStream(put1);
        FileInputStream streamRead2=new FileInputStream(put2);


        ArrayList<Integer> list=new ArrayList<Integer>();

        while (streamRead2.available()>0){
            int count=streamRead2.read();
            list.add(count);
        }
        System.out.print(list);
        while (streamRead1.available()>0){
            int count1=streamRead1.read();
            list.add(count1);
        }
        System.out.print(list);

        FileOutputStream streamWrite=new FileOutputStream(put1);
        for (int i=0;i<list.size();i++){

            streamWrite.write(list.get(i));
        }

    }
}
