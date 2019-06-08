# Week1TestFINAL
Coding Test Week 1
1. Create a singleton class and make it thread safe.
package com.example.week1testfinal;

![Screen Shot 2019-06-08 at 10 19 58 AM](https://user-images.githubusercontent.com/51377425/59148519-de2d5e80-89d7-11e9-9bb4-852dfe44da30.png)

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
2. Create a function to find the most occurrence of an integer value given an integer array.
public class Problem2 {
![Problem2](https://user-images.githubusercontent.com/51377425/59148518-de2d5e80-89d7-11e9-9036-e7e7b1f52c40.png)

    public static void main(String[] args) {

        int[] myArray;
        myArray = new int[]{1, 2, 1, 5, 6, 3, 5, 3, 6}; // gives Array
        System.out.println(getOccurence(myArray)); // calls array method with array passed through


    }

    static String getOccurence(int thisArray[]) {
        String ret = "";

        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>(); //creates new hashmap with key and values as Integer

        for (int i = 0; i < thisArray.length; i++) {             // loops and checks conditional if key is in hashmap
            if (myMap.containsKey(thisArray[i])) {
                myMap.put(thisArray[i], myMap.get(thisArray[i]) + 1);
            } else {
                myMap.put(thisArray[i], 1); //enters key if it has not been entered in the hashmap
            }

        }
        for (Map.Entry entry : myMap.entrySet()) {
            ret += (entry.getKey() + "  Occurs " + entry.getValue()); //prints every key and their value from hashmap
            ret += " times \n";

        }
        return ret;
    }
}

3. Simple Java Program to check or find if a number is Armstrong number or not. An Armstrong number of three digit is a number whose sum of cubes of its digit is equal to its number. For example 153 is an Armstrong number of 3 digit because 1^3+5^3+3^3 or 1+125+27=153
public class Problem3 {
![Problem3](https://user-images.githubusercontent.com/51377425/59148517-de2d5e80-89d7-11e9-8322-9709f66cb88e.png)


    public static void main(String[] args) {
        int checkNum = 153;
        System.out.println(isArmstrongNum(checkNum)); //calls boolean method true if armstrong

    }

    static Boolean isArmstrongNum(int num) {
        Boolean isArmstrong = false;
        int Checker = num;
        int temp = num;


        int first = temp / 100; //gets first digit
        temp = temp % 100;

        int second = temp / 10; //gets second digit
        temp = temp % 10;

        int third = temp;// gets third digit
        int cubed = (first * first * first) + (second * second * second) + (third * third * third);

        if (cubed == num) {  // conditional checking if cubed is equal to given number
            isArmstrong = true;
        }

        return isArmstrong;

    }

}

4. Complete the infected Room code challenge


![outbreak main](https://user-images.githubusercontent.com/51377425/59148515-dd94c800-89d7-11e9-911b-a99f4579cc88.png)
![outbreak class](https://user-images.githubusercontent.com/51377425/59148516-dd94c800-89d7-11e9-8630-8383f1e1efd0.png)

class Outbreak {


    public static void main(String[] args) {
        Room[][] verticalTrue = new Room[][]{
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)}
        };

        Boolean isInfected = isOutbreak(verticalTrue);
        System.out.println(isInfected);

    }

    private static boolean isOutbreak(Room[][] floor) {
        int result = 0;
        for (int i = 0; floor.length > i; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                int temp = checkRoom(0, floor, i, j);
                if (temp >= result) {
                    result = temp;
                }
            }
        }

        boolean b = result >= 5;
        return b;
    }

    private static int checkRoom(int num, Room[][] floor, int y, int x) {
        int result = num;

        if (y < 0 || y > floor.length) // condition to check out of bound exception
            return 0;
        if (y < 0 || x > floor[0].length) // 
            return 0;

        if ((floor[y][x]).visited) return 0;
        if (!(floor[y][x]).isInfected) return 0;

        floor[y][x].visited = true;

        result += 1;
        return result + checkRoom(0, floor, y + 1, x) //recursion to check 4 axis of an infected
                + checkRoom(0, floor, y - 1, x)
                + checkRoom(0, floor, y, x - 1)
                + checkRoom(0, floor, y, x + 1);

    }
}
public class Room {

    final boolean isInfected;
    boolean visited = false;


    Room(boolean infected) {  //
        isInfected = infected;
    }

}

