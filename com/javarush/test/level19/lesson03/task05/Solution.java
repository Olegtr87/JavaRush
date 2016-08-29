package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args){
        Customer incomeData=new Customer()  //пример ввода
        {

            @Override
            public String getCompanyName()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName()
            {
                return "Ukraine";
            }
        };
        Contact incomeData1= new Contact()
        {
            @Override
            public String getName()
            {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber()
            {
                return "+38(050)123-45-67";
            }
        };
        RowItem customer=new DataAdapter(incomeData,incomeData1);

        System.out.println(customer.getCompany());
        System.out.println(customer.getContactFirstName());
        System.out.println(customer.getContactLastName());
        System.out.println(customer.getCountryCode());
        System.out.println(customer.getDialString());

    }
    public static class DataAdapter implements RowItem {
        Customer customer;
        Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
        this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode()
        {
            String country = customer.getCountryName();
            String countryCode = "";

            for (Map.Entry<String, String> pair : countries.entrySet())
            {
                if (country.equals(pair.getValue()))
                {
                    return pair.getKey();
                }
            }

            return countryCode;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {   String s=contact.getName();
            String[] split=s.split(", ");
            return split[1];
        }

        @Override
        public String getContactLastName()
        {String s=contact.getName();
            String[] split=s.split(", ");
            return split[0];
        }

        @Override
        public String getDialString()
        {

            String phone = "callto://" + contact.getPhoneNumber().replaceAll("[()-]","");
            return phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}