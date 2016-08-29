package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        OutputStream output=new FileOutputStream(reader.readLine());
        String s=null;

        while (true){
            s=reader.readLine()+"\n";

            output.write(s.getBytes());

            if (s.equals("exit"+"\n")) break;

        }


    }
}
