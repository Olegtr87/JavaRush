package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<String>();
        String fileName;
        while(!(fileName = reader.readLine()).equals("exit")){
            names.add(fileName);
        }

        for(String s : names){
            new ReadThread(s).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        FileInputStream stream;
        ArrayList<Integer> list=new ArrayList<Integer>();
        String fileName;

        public ReadThread(String fileName) throws FileNotFoundException
        {
            this.fileName=fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            try
            {
                stream=new FileInputStream(this.fileName);
                while (stream.available()>0){
                    int c=stream.read();
                    list.add(c);
                }
                stream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


            int count=1, tmp=0, max=0,maxByte=0;

            for (int i=0;i<list.size();i++){
                count=1;
                for (int j=i+1;j<list.size();j++){
                    if (list.get(i)==list.get(j)) {count ++; tmp=list.get(i); list.remove(j);j--;}
                }
                if (count>max) {max=count; maxByte=tmp;}
            }
            synchronized (resultMap){
            resultMap.put(this.fileName,maxByte);}

        }

    }
}
