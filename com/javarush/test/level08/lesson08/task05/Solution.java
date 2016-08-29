package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] agrd){
        HashMap<String,String> map3=createMap();
        System.out.println(map3);
      removeTheFirstNameDuplicates(map3);
        System.out.print(map3);
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("Иванов", "Борис");
        map.put("Петров", "Иван");
        map.put("Сидоров", "Валентин");
        map.put("Апельбоэм", "Василий");
        map.put("Стул", "Иван");
        map.put("Пыл", "Василий");
        map.put("Глузд", "Валентин");
        map.put("Трутень", "Федор");
        map.put("Чад", "Вячеслав");
        map.put("Гад", "Борис");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String,String> map1=new HashMap<String, String>(map);
        HashMap<String,String> map2=new HashMap<String, String>(map);
        for(Map.Entry<String,String>pair1:map1.entrySet()){
            int clr=0;
            for (Map.Entry<String,String>pair2:map2.entrySet()){
                if (pair1.getValue().equals(pair2.getValue())) clr++;
            }
            if (clr>1 ) removeItemFromMapByValue(map, pair1.getValue());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
