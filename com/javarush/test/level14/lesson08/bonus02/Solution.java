package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.valueOf(reader.readLine());
        int b=Integer.valueOf(reader.readLine());
        int min=0;
        int nod=0;
        if (a<b) min=a; else min=b;
        for (int i=1;i<=min;i++){
            if (a%i==0 &&b%i==0) nod=i;
        }
        System.out.print(nod);

    }
}
