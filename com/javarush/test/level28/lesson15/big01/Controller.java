package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yulya on 03.05.2016.
 */
public class Controller
{
        private Provider[] providers;
        public Controller (Provider... providers) {
            if (providers.length == 0) {
                throw new IllegalArgumentException();
            }
            this.providers = providers;
        }
        @Override
        public String toString()
        {
            return "Controller{" +
                    "providers=" + Arrays.toString(providers) +
                    '}';
        }

    public void scan()
    {
        List<Vacancy> vacancies = new ArrayList<>();
        try
        {
            for (Provider provider : providers)
            {
                for(Vacancy vac : provider.getJavaVacancies("SOME TEXT"))
                    vacancies.add(vac);
            }
        }catch (NullPointerException e)        {

        }
        System.out.println(vacancies.size());

    }
}


