package com.javarush.test.level22.lesson05.task02;

import java.util.ArrayList;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.print(getPartOfString("d\t\tsdf\t\t"));
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null) throw new TooShortStringException();

        char[] array=string.toCharArray();
        int j=0,index1=0;

        for (int i=0;i<array.length;i++){
            if (String.valueOf(array[i]).equals("\t")) j++;
            if ((j==2)) {index1=i;break;}
        }

        if (j<2) throw new TooShortStringException();
        int index0=string.indexOf("\t")+1;

        string=string.substring(index0,index1);
        return string;
    }

    public static class TooShortStringException extends Exception {
    }
}
