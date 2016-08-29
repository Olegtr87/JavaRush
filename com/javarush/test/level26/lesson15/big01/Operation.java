package com.javarush.test.level26.lesson15.big01;


/**
 * Created by Администратор on 16.10.15.
 */
public enum Operation
{INFO, DEPOSIT, WITHDRAW, EXIT;

   public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException{
            Operation operation = null;

           switch (i)
           {
               case 1:
                   return operation=Operation.INFO;
               case 2:
                   return operation=Operation.DEPOSIT;
               case 3:
                   return operation=Operation.WITHDRAW;
               case 4:
                   return operation=Operation.EXIT;
               default:
                    throw new IllegalArgumentException();
           }

   }
}




