package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();
        FileInputStream inputStream=new FileInputStream(file);

        ArrayList<Integer> array=new ArrayList<Integer>();

        while (inputStream.available()>0){
            int data=inputStream.read();
            array.add(data);
        }
        inputStream.close();

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<array.size();i++){
            count=0;
            for(int j=i+1;j<array.size();j++){
                if (array.get(i)==array.get(j)) {
                    count++;
                    map.put(array.get(i),count+1);
                    array.remove(j);
                    j--;
                }
            }
        }
        int max=0, tmp=0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tmp = entry.getValue();
            if (tmp>max) {max=tmp;}

        }

        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            tmp = entry1.getValue();
            int tmp1=entry1.getKey();
            if (max==tmp) {System.out.print(tmp1+" ");}

        }

    }
}
