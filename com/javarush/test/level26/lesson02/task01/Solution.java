package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution  {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final double median;
        if (array.length%2!=0) median=array[array.length/2];
        else median=((double)array[array.length/2]+array[array.length/2-1])/2;

        Comparator<Integer> compareByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double value = Math.abs(o1-median) - Math.abs(o2-median);
                if (value == 0)
                    value = o1 - o2;
                return (int)value;
            }
        };
        Arrays.sort(array, compareByMedian);
        System.out.println(median);
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array=new Integer[5];
        array[0]=5;
        array[1]=8;
        array[2]=13;
        array[3]=15;
        array[3]=17;

        //sort(array);

    }



}
