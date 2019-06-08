package com.example.week1testfinal;

public class Problem3 {


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

