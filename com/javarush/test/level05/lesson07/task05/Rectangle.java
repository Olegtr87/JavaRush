package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    public double left=4;
    public double top=8;
    public double width=5;
    public double height=6;


    public void initialize(double left, double top, double width, double height){
        this.left=left;
        this.height=height;
        this.top=top;
        this.width=width;
    }

    public void initialize(double left, double top){
        this.left=left;
        this.width=4;
        this.top=top;
        this.height=7;

    }
    public void initialize(double left, double top, double height){
        this.left=left;
        this.height=height;
        this.top=top;
        this.width=height;
    }
    public void initialize(/*double left, double top, double width, double height*/){
        this.left=5;
        this.height=8;
        this.top=5;
        this.width=6;
    }
    //Напишите тут ваш код

}
