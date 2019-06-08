package com.example.week1testfinal;



import java.util.HashMap;
import java.util.Map;

public class Problem2 {

    public static void main(String[] args) {

        int[] myArray;
        myArray = new int[]{1, 2, 1, 5, 6, 3, 5, 3, 6}; // gives Array
        System.out.println(getOccurence(myArray)); // calls array method with array passed through


    }

    static String getOccurence(int thisArray[]) {
        String ret = "";

        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < thisArray.length; i++) {
            if (myMap.containsKey(thisArray[i])) {
                myMap.put(thisArray[i], myMap.get(thisArray[i]) + 1);
            } else {
                myMap.put(thisArray[i], 1);
            }

        }
        for (Map.Entry entry : myMap.entrySet()) {
            ret += (entry.getKey() + "  Occurs " + entry.getValue());
            ret += " times \n";

        }
        return ret;
    }
}

