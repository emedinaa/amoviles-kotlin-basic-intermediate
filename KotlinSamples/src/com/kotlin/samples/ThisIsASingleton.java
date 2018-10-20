package com.kotlin.samples;

public class ThisIsASingleton {

    private static ThisIsASingleton instance;

    private ThisIsASingleton(){}

    public static synchronized ThisIsASingleton getInstance(){
        if(instance == null){
            instance = new ThisIsASingleton();
        }
        return instance;
    }
}
