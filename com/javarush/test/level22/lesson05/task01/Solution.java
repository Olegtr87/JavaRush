package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {
        String s=getPartOfString("JavaRush - лучший сервис обучения Java.");
        System.out.print(s);
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null) throw new TooShortStringException();

        char[] ch=string.toCharArray();
        int j=0;
        int ind=0;
        for (int i=0;i<ch.length;i++){
            if (String.valueOf(ch[i]).equals(" ")) j++;
            if (j==4) ind=i;
        }
        if (j<4) throw new TooShortStringException();

        int index=string.indexOf(" ");
        string=string.substring(index+1, ind+1);

        return string;
    }

    public static class TooShortStringException extends Exception
    {

    }
}
