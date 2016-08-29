package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args)
    {
        String[] s=getTokens("sdfsdf.sdfsdf.sdfsdf.wer",".");
        for (int i=0;i<s.length;i++)
        System.out.println(s[i]);
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer token=new StringTokenizer(query,delimiter);
        String[] s=new String[token.countTokens()];
        int i=0;
        while (token.hasMoreTokens()){
          String tok=token.nextToken();
            s[i]=tok;
            i++;
        }
        return s;
    }
}
