package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/


public class Cat
{


    public String name="Vaska";
    public int weight=6;//Напишите тут ваш код
    public int age=0;

    public String color=null;
    public String adres=null;

public void initialize (String name){
    this.name=name;
    this.age=5;
    this.weight=6;


}
    public void initialize (String name, int age){
        this.name=name;
        this.age=age;
        this.weight=6;

    }
    public void initialize (String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;

    }
    public void initialize (int weight, String color){
        this.color=color;
        this.weight=weight;
        this.age=5;

    }
    public void initialize (String color, int weight,String adres)
    {
        this.color = color;
        this.weight=weight;
        this.adres = adres;
        this.age=8;

    }

}
