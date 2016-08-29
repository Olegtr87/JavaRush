package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        FileInputStream inputStream1=new FileInputStream(file1);
        String file2=reader.readLine();
        FileOutputStream outputStream2=new FileOutputStream(file2);
        String file3=reader.readLine();
        FileOutputStream outputStream3=new FileOutputStream(file3);

        int sizeFile1=inputStream1.available();

        byte[] buffer = new byte[inputStream1.available()*2];
        if (sizeFile1 %2==0)
        {
            int count = inputStream1.read(buffer);
            outputStream2.write(buffer, 0, count/2 );
            outputStream2.close();
            outputStream3.write(buffer, count/2, count/2 );
            outputStream3.close();
       } else {
            int count = inputStream1.read(buffer);
            outputStream2.write(buffer, 0, count/2+1 );
            outputStream2.close();
            outputStream3.write(buffer, count/2+1, count/2 );
            outputStream3.close();

        }

    }
}
