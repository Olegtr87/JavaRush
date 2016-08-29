package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream stream=new FileInputStream(args[0]);
        int count=0,count1=0;
        while(stream.available()>0){
            int c=stream.read();
            count++;
            if (c==32) count1++;
        }

        stream.close();
        double res=(double)count1/count*100.00;
        System.out.print(String.format(Locale.getDefault(), "%.2f", res));

    }
}
