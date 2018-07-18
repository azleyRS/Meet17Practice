package com.example.rus.meet17practice;

import java.util.ArrayList;
import java.util.List;

public class PersonListSingleton {
    private static List<Person> INSTANCE = null;

    public PersonListSingleton() {
    }

    public static List<Person> getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ArrayList<>();
        }
        return INSTANCE;
    }

    public static void addPerson(Person person){
        getInstance().add(person);
    }
}
