package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();

        FileInputStream inputStream= new FileInputStream(file);
        load(inputStream);
        inputStream.close();

        reader.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Map.Entry<String,String> p:properties.entrySet())
        {
            printWriter.println(p.getKey()+"="+p.getValue());
        }
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader1=new BufferedReader(new InputStreamReader(inputStream));

        String[] array;

            while (reader1.ready())
            {
                String parameter=reader1.readLine();
                array=parameter.split("=");
                properties.put(array[0],array[1]);
            }
reader1.close();
    }
}
