package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readik=new BufferedReader(new InputStreamReader(System.in));
        String fileR=readik.readLine();
        String fileW=readik.readLine();
        FileInputStream reader=new FileInputStream(fileR);
        FileOutputStream writer=new FileOutputStream(fileW);
        int count=0;
        while (reader.available()>0){
            int c=reader.read();
            count++;
            if (count %2==0) writer.write(c);
        }


    }
}
