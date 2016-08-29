package com.javarush.test.level24.lesson06.home03;

/**
 * Created by Администратор on 05.08.15.
 */
public abstract class AbstractJeans implements Jeans
{int length;
    int size;
    int id;
    double price;
    protected AbstractJeans(int id, int length, int size, double price)
    {this.id=id;
        this.length=length;
        this.size=size;
        this.price=price;
    }

    @Override
    public int getLength()
    {
        return length;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName()+"{" +
                "id=" + id +
                ", length=" + length +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
