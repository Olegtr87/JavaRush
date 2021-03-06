package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader readik = new BufferedReader(new InputStreamReader(System.in));
        String fileR = readik.readLine();
        String fileW = readik.readLine();
        FileReader reader = new FileReader(fileR);
        FileWriter writer = new FileWriter(fileW);
        String s = "";

        while (reader.ready())
        {
            int c = reader.read();
            s = String.valueOf((char) c);
            s = s.replaceAll("\\p{Punct}", "");
                writer.write(s);

        }

        reader.close();
        writer.close();
    }
}
