package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Администратор on 16.10.15.
 */
 interface Command
{ void execute() throws InterruptOperationException;
}
