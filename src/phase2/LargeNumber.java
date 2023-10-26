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
        }
        else
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
    @Override
    public int compareTo(LargeNumber o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
