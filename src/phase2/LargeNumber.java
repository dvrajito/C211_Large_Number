/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru, Gavin Power, Brandon Jones, Charlie Kinnett, Tiffany Leister, Katie DeLucio, Madeline Abbott, Jack Ventura, Matthew Molewyk, Titus Duncan, Daniel Guernsey, Jiya Stroder, Jennifer Rose
 * Class: LargeNumber
 * Implements an integer number of an unlimited size and
 * a few useful arithmetic operations.
 ************************************************************/

package phase2;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;

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
        else
            number = new ArrayList<Integer>(0); // create an empty array

		// If n is 0 the while loop will not store anything in the array
        if (n == 0) { // the while loop by itself would leave the array empty
            number.add(0);
        }
        
        // Convert the n to decimals and add it to the array one by one
        while (n > 0) {
            int dec = n % 10;
            number.add(dec);
            n = n / 10;
        }
    }

    // copy constructor
    public LargeNumber(LargeNumber other) {
        init(other);
    }

    // Initialize the object with a copy of another object
    public void init(LargeNumber other) {
        sign = other.sign;

        if (number != null)
            number.clear(); // Clear existing data if any

        number = new ArrayList<Integer>(0);

        // copy them manually
        for (Integer i : other.number)
            number.add(i);

        // use copy from Collections - something wrong with the size
        // Collections.copy(number, other.number); 
    }

    // Team 6
    public LargeNumber(String n) {
        init(n);
    }

    // Team 6 - Done
    public void init(String n) {
        // clear number arrayString
        if (number != null) {
            number.clear();
        } else {
            number = new ArrayList<Integer>(0); // create an empty array
        }
        // check if the number in the beginning is pos or neg
        if (n.charAt(0) == '-') {
            sign = -1;
        } else
            sign = 1;

        // add it to the arrayList one number at a time
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (Character.isDigit(c)) { // test to make sure that each item is a character
                int charNumber = Integer.parseInt("" + c);
                number.add(0, charNumber);
            }
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
    
    // DV and Teams 4 and 9
    public int toInt() {
        int wholeNumber = 0;

        for (int i = this.getSize() - 1; i >= 0; i--) {
            wholeNumber = wholeNumber * 10 + number.get(i);
        }
        return wholeNumber;
    }
        
    /********************************************************/
    // Team 3: Trace Crafton, Jon Fulkerson, Stephen Torrijas - Done
    // Function allowing us to compare two arrays as integers
    // Should return 1 if this is larger than other, 0 if they are equal
    public int compareTo(LargeNumber o) {

        // Declare variables used during function
        int thisSign = this.getSign();
        int otherSign = o.getSign();
        int thisSize = this.getSize();
        int otherSize = o.getSize();
        // Subtract one from size to get true index
        int thisIndex = thisSize - 1;
        int otherIndex = otherSize - 1;

        if (thisSign > otherSign) {
            return 1; // This is positive, o is negative
        } else if (thisSign < otherSign) {
            return -1; // This is negative, o is positive
        }
        
        // Dealing with negative numbers properly:
        if (thisSign < 0) { // and o.sign < 0
            this.sign = 1;
            o.sign = 1;
            int result = this.compareTo(o);
            this.sign = -1;
            o.sign = -1;
            return -result; // the opposite is true for negative numbers
        }

        // Skip trailing zeros by decrementing the index if
        // index greater than or equal to 0 and number at index
        // is equal to 0
        while (thisIndex >= 0 && this.number.get(thisIndex) == 0) {
            thisIndex--;
        }
        while (otherIndex >= 0 && o.number.get(otherIndex) == 0) {
            otherIndex--;
        }

        // After skipping zeros, if the indexes are not equal,
        // we can compare the indexes and this will tell us which
        // number is bigger/smaller
        if (thisIndex != otherIndex) {
            if (thisIndex > otherIndex) {
                return 1;
            } else {
                return -1;
            }
        }

        // While thisIndex is larger than 0, we compare the number
        // at the thisIndex to the other number at the same index
        while (thisIndex >= 0) {
            int thisDigit = this.number.get(thisIndex);
            int otherDigit = o.number.get(thisIndex);
            if (thisDigit != otherDigit) {
                if (thisDigit > otherDigit) {
                    return 1;
                } else {
                    return -1;
                }
            }
            thisIndex--;
        }

        return 0; // Both numbers are equal
    }

    // Team 1
    // Addition Function
    // Katie Delucio, Maddie Abbott, Tiffany Leister - Done
    public void add(LargeNumber other) {
        int nextDig = 0;
        // Checking if signs are different
        // If so, subtraction method is carried out
        if (this.sign != other.sign) {
            other.sign = -other.sign;
            this.subtract(other);
            other.sign = -other.sign;
        } else {
            // checking size and adding 0 if necessary
            for (int i = (this.number.size()); i < (other.number).size(); i++) {
                (this.number).add(0);
            }
            for (int i = (other.number.size()); i < (this.number).size(); i++) {
                (other.number).add(0);
            }
            for (int i = 0; i < other.getSize(); i++) {
                int sum = (this.number).get(i) + (other.number).get(i) + nextDig;
                // If sum of two digits is larger than 10, store result
                if (sum < 10) {
                    (this.number).set(i, sum);
                    nextDig = 0;
                } else {
                    (this.number).set(i, sum - 10);
                    nextDig = 1;
                }
            }
            // Add new element to array number
            if (nextDig == 1) {
                (this.number).add(1);
            }
        }

        other.cleanTrail();
    }

    /**********************************************************************************************
     * Team 2
     * Author :: Amstrong Akendung, Alyssa Martinez, Mario Garcilazo
     * Description :: This method perform Subtraction of Large Number by first
     * checking their sign.
     * if they different it convert into an Addition else, it compare the magnitude
     * and does
     * the subtraction accordingly with help of subtractFromLarge Helper method
     *
     ******************************************************************************************/
     public void subtract(LargeNumber other) {
        // Check if signs are different
        if (this.sign != other.sign) {
            // Change the sign of 'other' and Perform Addition
            other.sign = -other.sign;
            this.add(other);
            other.sign = -other.sign;

        } else {
            // Handle subtraction for numbers with the same sign
            int comparison = this.compareTo(other);

            if (comparison == 0) {
                this.init(0);
                // Numbers are equal, result should be zero
                //System.out.println("Subtraction result: 0");
            } else if (comparison > 0) {
                // 'this' is larger, perform subtraction
                subtractFromLarge(this.number, other.number);
            } else {
                // 'other' is larger, perform subtraction using copies and adjust the sign
                LargeNumber thisCopy = new LargeNumber(this);
                LargeNumber otherCopy = new LargeNumber(other);
                subtractFromLarge(otherCopy.number, thisCopy.number);
                this.init(otherCopy);
                this.sign = -this.sign;
            }
        }

    }

    // Helper method for subtracting two positive ArrayLists representing
    // LargeNumbers.
    private void subtractFromLarge(ArrayList<Integer> from, ArrayList<Integer> value) {
        int carry = 0;
        // return the max number of digit btw this and Other
        int maxDigits = Math.max(from.size(), value.size());

        // loop through each digit position from right to left.
        for (int i = 0; i < maxDigits; i++) {
            int digit1 = i < from.size() ? from.get(i) : 0;
            int digit2 = i < value.size() ? value.get(i) : 0;
            int result = digit1 - digit2 - carry;

            if (result < 0) {
                result += 10;
                carry = 1;
            } else {
                carry = 0;
            }

            if (i < from.size()) {
                from.set(i, result);
            } else {
                from.add(result);
            }
        }
    }

    // Team 4 - Done
    public void multiply(LargeNumber other) {
        LargeNumber copiedLN = new LargeNumber(this);
        LargeNumber otherCopy = new LargeNumber(other);
        int saveSign; // will hold the final sign for this object
        LargeNumber one;

     // check signs of each number
        // Finding the final sign
        if (this.getSign() == other.getSign()) {
            saveSign = 1;
        } else {
            saveSign = -1;
        }
   
        copiedLN.sign = 1; // multiply the positive numbers
        this.sign = 1;
        otherCopy.sign = 1;
        one = new LargeNumber(1);

        while (otherCopy.compareTo(one) > 0) { // while otherCopy > 1
            this.add(copiedLN);                // this += copy
            otherCopy.subtract(one);           // otherCopy--
        }
        
        this.sign = saveSign;
    }

    // Team 5: Jack Ventura, Titus Duncan, Matthew Molewyk - Done
    // Method that takes a number as a parameter and divides an existing number by
    // the parameter
    public void divide(LargeNumber other) {
        // make copies of our objects
        LargeNumber dividend = new LargeNumber(this);
        LargeNumber divisor = new LargeNumber(other);
        int saveSign; // will hold the final sign for this object
        LargeNumber one = new LargeNumber(1);

        // check signs of each number
        // Finding the final sign
        if (this.getSign() == other.getSign()) {
            saveSign = 1;
        } else {
            saveSign = -1;
        }

        this.sign = 1;
        this.init(0);
        divisor.sign = 1;
        dividend.sign = 1;

        while (dividend.compareTo(divisor) >= 0) { // dividend >= divisor
            this.add(one);                         // result++
            dividend.subtract(divisor);            // dividend -= divisor
        }

        this.sign = saveSign;
    }

    // Team 7: Daniel Guernsey, Jiya Stroder, Jennifer Rose - Done
    public void percent(LargeNumber other) {
        LargeNumber copy = new LargeNumber(this);
        copy.divide(other);
        copy.multiply(other);
        this.subtract(copy);
    }

    // Team 8: Gavin Power, Brandon Jones, Charlie Kinnett - Done
    // This is a method that removes all trailing 0s in a LargeNumber object
    // with a test in TestNumber.java titled testCleanTrail
    public void cleanTrail() {
        // Remove current member until current member does not equal 0.
        int digit = getSize() - 1;
        while (digit > 0) {
            if (number.get(digit) > 0) // There are no more trailing zeroes.
                break;
            number.remove(digit);
            digit--;
        }
    }
    
    // Check if the number is equal to 0.
    public boolean isZero() {
        return getSize() == 1 && number.get(0) == 0;
    }

    // Team 9: Gaven Van Skyock, Thomas Polega - Done
    public void power(LargeNumber other) {
        if (this.isZero()) // 0 to any power is 0
            return;

        // If the exponent (other) is 0, set the result to 1 and return
        if (other.isZero()) {
            this.init(1);
            return;
        }

        // Check if the exponent is negative
        // An non-0 integer to a negative power is less than 1 in absolute value
        // so it truncates to 0.
        if (other.getSign() < 0) {
            this.init(0);
            return;
        }

        LargeNumber base = new LargeNumber(this);
        LargeNumber exponent = new LargeNumber(other);
        LargeNumber zero = new LargeNumber(0);
        LargeNumber two = new LargeNumber(2);

        // Initialize the result to 1
        this.init(1);
        while (exponent.compareTo(zero) > 0) {
            // If the exponent is odd, multiply the result by the base
            if (exponent.number.get(0) % 2 != 0) { // is the exponent odd?
                this.multiply(base);
            }

            // Divide the exponent by 2
            exponent.divide(two);

            // Square the base (result)
            base.multiply(base);
        }

        // If the base (this) was negative and the exponent was even, make the result
        // positive
        // if (this.sign < 0 && other.number.get(0) % 2 == 0) { // - not necessary
        // this.sign = 1;
        // }
    }
}
