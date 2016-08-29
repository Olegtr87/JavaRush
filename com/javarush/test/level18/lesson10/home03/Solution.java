package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1=new BufferedReader(new InputStreamReader(System.in));
        String put1=reader1.readLine();
        String put2=reader1.readLine();
        String put3=reader1.readLine();

        FileInputStream stream1=new FileInputStream(put2);
        FileInputStream stream2=new FileInputStream(put3);
        FileOutputStream streamOut=new FileOutputStream(put1);

        while (stream1.available()>0){
            int c=stream1.read();
            streamOut.write(c);
        }
        while (stream2.available()>0){
            int c=stream2.read();
            streamOut.write(c);
        }

        stream1.close();
        stream2.close();
        streamOut.close();
    }
}
