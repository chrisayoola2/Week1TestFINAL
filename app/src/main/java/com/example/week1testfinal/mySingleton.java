package com.example.week1testfinal;

public class mySingleton {


    private static mySingleton instance = null;

    private mySingleton() {

    }


    synchronized public static mySingleton getInstance() {

        if (instance == null) {  //checks if instance has been initiated
            instance = new mySingleton(); //
        }
        return instance;
    }

}