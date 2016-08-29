package com.javarush.test.level14.lesson08.home02;

/* Дегустация вин
1. Создать абстрактный класс Drink с реализованным методом public void taste(), который выводит в консоль "Вкусно"
2. Создать класс Wine, который наследуется от Drink, с реализованным методом public String getHolidayName(), который возвращает строку "День рождения"
3. Создать класс BubblyWine, который наследуется от Wine, с реализованным методом public String getHolidayName(), который возвращает строку "Новый год"
4. Написать реализацию методов getDeliciousDrink, getWine, getBubblyWine
5. Каждый класс и интерфейс должны быть в отдельных файлах
6. Метод main менять нельзя!
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {

        return new Wine();
    }

    public static Wine getWine() {
       Wine wine=new Wine();
        return wine;
    }

    public static Wine getBubblyWine() {
        BubblyWine bwine=new BubblyWine();
            return bwine;
    }
}
abstract class Drink{
    public void taste(){
       System.out.println("Вкусно");
    }
}
class Wine extends Drink{
    public String getHolidayName(){
        return "День рождения";
    }
}
class BubblyWine extends Wine{
    public String getHolidayName(){
        return "Новый год";
    }
}