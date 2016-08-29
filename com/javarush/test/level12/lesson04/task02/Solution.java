package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
       print(4);
        print(4);

    }
    public static void print(int a){
        System.out.print ("int");
    }
    public static void print (Integer b){
        System.out.print ("Int");
    }
    //Напишите тут ваши методы
}
