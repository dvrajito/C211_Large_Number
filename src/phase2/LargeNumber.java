/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru
 * Class: LargeNumber
 * Implements an integer number of an unlimited size and 
 * a few useful arithmetic operations.
 ************************************************************/

package phase2;

import java.util.ArrayList; // import the ArrayList class

// A class designed to store large integers in an array called number
// with the sign stored in the attribute sign.
public class LargeNumber implements Comparable<LargeNumber> {

    ArrayList<Integer> number;
    int sign;

    // Default constructor: initialize as 0
    public LargeNumber() {
        number = new ArrayList<Integer>(1);
        number.set(0, 0);
        sign = 1; // positive
    }

    // Constructor with a given non-negative integer
    public LargeNumber(int n) {
        init(n);
    }

    // Initialize the object based on converting an integer to decimals
    public void init(int n) {
        if (n < 0) {
            n = -n; // store the absolute value in number
            sign = -1;
        } else
            sign = 1;
        if (number != null)
            number.clear(); // Clear existing data if any

        number = new ArrayList<Integer>(0); // start with an empty array
        // Convert the n to decimals and add it to the array one by one
        while (n > 0) {
            int dec = n % 10;
            number.add(dec);
            n = n / 10;
        }
    }

    // Team 6
    public LargeNumber(String n) {

    }

    // Team 6
    public void init(String n) {

    }

    // find out the number of digits
    public int getSize() {
        return number.size();
    }

    // find out the sign
    public int getSign() {
        return sign;
    }

    // overriding the toString() method
    public String toString() {
        String result = "";
        for (Integer i : number)
            result = "" + i + result; // add each new digit at the front
        if (sign < 0) // add the sign at the front
            result = "-" + result;
        return result;
    }

    // Function allowing us to sort an array of large numbers
    // Should return ` if this is larger than other, 0 if they are equal
    // and -1 if this is smaller than other.
    // Team 3
    @Override
    public int compareTo(LargeNumber other) {
        return 0; // statement so that the function compiles
    }

    // Team 1
    public void add(LargeNumber other) {

    }

    // Team 2
    public void subtract(LargeNumber other) {

    }

    // Team 4
    public void multiply(LargeNumber other) {
        LargeNumber copiedLN = this;
        // Execute the multiplication on the copy
        for(int i = other.getSize(); i < 0; i--) {
            copiedLN.add(other);
        }
        // Finding the final sign
        if(copiedLN.getSign() == other.getSign()) {
            copiedLN.sign = 1;
        } else {
            copiedLN.sign = -1;
        }
        System.out.println("The multiplied number is: " + copiedLN); // test toString
        System.out.println("The multiplied number has " + copiedLN.getSize() + " digits.");
        if (copiedLN.getSign() > 0)
            System.out.println("The multiplied number is positive.");
        else
            System.out.println("The multiplied number is negative.");
    }

    // Team 5
    public void divide(LargeNumber other) {

    }

    // Team 7
    public void percent(LargeNumber other) {

    }

    // Team 8
    public void cleanTrail() {

    }

    // Team 9
    public void power(LargeNumber other) {

    }
}
