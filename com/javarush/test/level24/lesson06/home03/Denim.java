package com.javarush.test.level24.lesson06.home03;

/**
 * Created by Администратор on 05.08.15.
 */
public class Denim extends AbstractJeans
{   String TM;
    public Denim(int id, int length, int size, double price)
    {
        super(id, length, size, price);
    }



    @Override
    public String getTM()
    {
        return TM;
    }
}
