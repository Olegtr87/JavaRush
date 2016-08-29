package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");

            Object object = new Object();
            object.string1 = new String1();   //string #1
            object.string2 = new String1();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String1(); //string #3
            loadedObject.string2 = new String1(); //string #4


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            System.out.println(object.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String1 string1;
        public String1 string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer=new PrintWriter(outputStream);

            writer.println(new String1());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
//            String str=new String();

        }
    }

    public static int countStrings;

    public static class String1 {
        private final int number;

        public String1() {

            number = ++countStrings;
        }

        public void print() {

            System.out.println("string #" + number);
        }
    }
}
