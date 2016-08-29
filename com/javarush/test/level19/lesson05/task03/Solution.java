package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readik = new BufferedReader(new InputStreamReader(System.in));
        String fileR = readik.readLine();
        String fileW = readik.readLine();
        FileInputStream reader1 = new FileInputStream(fileR);
        //FileReader reader = new FileReader(fileR);
        FileOutputStream writer = new FileOutputStream(fileW);

        String[] s=new String[reader1.available()];
        String ss="";
        while (reader1.available()>0){
            int c=reader1.read();
            ss=ss+String.valueOf((char)c);
        }

        s=ss.split(" ");
        reader1.close();

        for (int i=0;i<s.length;i++) {

            if (checkString(s[i])) {
                char[] sss=s[i].toCharArray();
                for (int j=0;j<sss.length;j++)
                    writer.write(sss[j]);
                writer.write(32);
                }
        }


    }
    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
