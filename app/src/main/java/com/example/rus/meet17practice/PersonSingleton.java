package com.example.rus.meet17practice;

public class PersonSingleton {
    private static PersonSingleton INSTANCE = null;

    private String surname;
    private String name;
    private String secondName;

    private PersonSingleton() {
    }
    public static PersonSingleton getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PersonSingleton();
        }
        return INSTANCE;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
