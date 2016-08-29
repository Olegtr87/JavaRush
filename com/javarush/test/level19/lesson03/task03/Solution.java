package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args){
        IncomeData incomeData=new IncomeData()  //пример ввода
        {
            @Override
            public String getCountryCode()
            {
                return "UA";
            }

            @Override
            public String getCompany()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName()
            {
                return "Ivan";
            }

            @Override
            public String getContactLastName()
            {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 38;
            }

            @Override
            public int getPhoneNumber()
            {
                return 501234;     //указал неполный номер
            }
        };
        Customer customer=new IncomeDataAdapter(incomeData);
        Contact contact=new IncomeDataAdapter(incomeData);
        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());
        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());
    }
    public static class IncomeDataAdapter implements Customer,Contact  {
        IncomeData object;
        IncomeDataAdapter(IncomeData object){
            this.object=object;
        }
        @Override
        public String getName()
        {
            return object.getContactLastName()+", "+object.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {   String s=String.valueOf(object.getPhoneNumber());
            while (!(s.length() ==10)){
                s="0"+s;
            }
            char[] ch=s.toCharArray();
            return "+"+object.getCountryPhoneCode()+"("+ch[0]+ch[1]+ch[2]+")"+ch[3]+ch[4]+ch[5]+"-"+ch[6]+ch[7]+"-"+ch[8]+ch[9];
        }

        @Override
        public String getCompanyName()
        {
            return object.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(object.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
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