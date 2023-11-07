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

    // Team 6
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
        } else {
            sign = 1;
        }
        // add it to the arrayList one number at a time
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (Character.isDigit(c) == true) { // test to make sure that each item is a character
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

    /********************************************************/
    // Team 3: Trace Crafton, Jon Fulkerson, Stephen Torrijas
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
    // Katie Delucio, Maddie Abbott, Tiffany Leister
	public void add(LargeNumber other) {
        int nextDig = 0;
        // Checking if signs are different
        // If so, subtraction method is carried out
        if (this.sign != other.sign) {
        	other.sign=-other.sign;
            this.subtract(other); 
            other.sign=-other.sign;
        }
        //checking size and adding 0 if necessary
        	for (int i=(this.number.size()); i < (other.number).size(); i++) { // DV: add another similar loop
        		(this.number).add(0);             // where you switch around this and other - KD: done, thanks!
        	}
		for (int i=(other.number.size()); i < (this.number).size(); i++) { 
                (other.number).add(0);             
            }
            for (int i = 0; i < other.getSize(); i++) {
                int sum = (this.number).get(i) +
                        (other.number).get(i) + nextDig;
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
       this.cleanTrail();
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
                // Numbers are equal, result should be zero
                this.init(0); // Set this LargeNumber to 0
            } else if (comparison > 0) {
                // 'this' is larger, perform subtraction
                subtractFromLarge(this.number, other.number);
            } else {
                // 'other' is larger, perform subtraction and adjust the sign
                LargeNumber temp = new LargeNumber(other); // Create a copy of 'other'
                subtractFromLarge(temp.number, this.number);
                this.init(temp); // Copy 'temp' back into 'this'
                this.sign = -1;
            }
        }

    }

    // Helper method for subtracting two positive ArrayLists representing
    // LargeNumbers.
    private void subtractFromLarge(ArrayList<Integer> from, ArrayList<Integer> value) {
        int carry = 0;
        int leadingZeros = 0;
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

            if (result != 0) {
                leadingZeros = 0;
            } else if (result == 0 && leadingZeros >= 0) {
                leadingZeros++;
            }

            if (i < from.size()) {
                from.set(i, result);
            } else {
                from.add(result);
            }
        }
          // Remove leading zeros
        while (leadingZeros > 0) {
            from.remove(from.size() - 1);
            leadingZeros--;
        }
    }

    // Team 4
    public int toInt() {
        int wholeNumber = 0;

        for (int i = this.getSize(); i > 0; i--) {
            wholeNumber += this.number.get(i - 1) * (int) Math.pow(10, i - 1);
        }
        return wholeNumber;
    }

    // Team 4
    public void multiply(LargeNumber other) {
        LargeNumber copiedLN = new LargeNumber(this);
        LargeNumber otherCopy = new LargeNumber(other);

        // Execute the multiplication *using* the copy
        // LargeNumber larger, smaller; DV : not needed - it doesn't make a difference
        // JD: I'm not sure why this would not be needed, When you multiply large
        // numbers,
        // you need to have the larger number on the top. This is because you multiply
        // the top number by each digit of the bottom number, and then add them
        // together.

        // if (this.compareTo(other) > 0) {
        // larger = this;
        // smaller = other;
        // } else {
        // larger = other;
        // smaller = this;
        // }

        // Finding the final sign
        if (this.getSign() == other.getSign()) {
            this.sign = 1;
        } else {
            this.sign = -1;
        }

        // DV : here make the signs of this, copyLN, and otherCopy 1.
        // Declare large numbers zero(0) and one(1);
        // JD: ^ This was never mentioned and is not mentioned again
        // What is the purpose of this?
        while (this.compareTo(otherCopy) > 0) { // DV: compare otherCopy to zero using compareTo
            this.add(otherCopy);
            // DV: subtract one from otherCopy using the subtract function.
            // JD: Why? What does subtraction have to do with multiplication?
            // Also the subtract function uses large numbers,
            // similar to the add function...
            this.subtract(otherCopy);
            // JD: What good does this do?? This is just adding and subtracting the same
            // number...
        }

    }

    // Team 5: Jack Ventura, Titus Duncan, Matthew Molewyk
    // Method that takes a number as a parameter and divides an existing number by
    // the parameter
    public void divide(LargeNumber other) {
        // make copies of our objects
        LargeNumber dividend = new LargeNumber(this);
        LargeNumber divisor = new LargeNumber(other);

        // check signs of each number
        if (this.getSign() == other.getSign()) {
            this.sign = 1;
        } else {
            this.sign = -1;
        }

        // int otherSign = other.sign;
        // other.sign = this.sign;
        // dividend.sign = 1;
        // divisor.sign = 1;

    }

    // Team 7: Daniel Guernsey, Jiya Stroder, Jennifer Rose
    // We need to cut the quotient off at the decimal, but can't see
    // in the divide function how to manage that
    // then run the multiply function of whole number(quotient) times whole number(divisor)
    // and subtract that from the original LargeNumber(this)
    public void percent(LargeNumber other) {
        LargeNumber copy = new LargeNumber(this);
        copy.divide(other);
        copy.multiply(other);
        this.subtract(copy);
    }

    // Team 8: Gavin Power, Brandon Jones, Charlie Kinnett
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

    // Team 9: Gaven Van Skyock, Thomas Polega
    public void power(LargeNumber other) {
	// Create a copy of the current LargeNumber
        LargeNumber result = new LargeNumber();

        // If the exponent (other) is 0, set the result to 1 and return
        if (other.getSize() == 1 && other.number.get(0) == 0) {
            this.init(1);
            return;
        }

        // Check if the exponent is negative
        boolean isNegativeExponent = other.getSign() < 0;

        // Check if the current LargeNumber is negative
        boolean isNegativeBase = this.getSign() < 0;

        // Convert the exponent to a positive integer
        int exponent = 0;
        for (int i = 0; i < other.getSize(); i++) {
            exponent = exponent * 10 + other.number.get(i);
        }

        // Initialize the result to 1
        this.init(1);

        while (exponent > 0) {
            // If the exponent is odd, multiply the result by the base
            if (exponent % 2 != 0) {
                this.multiply(result);
            }

            // Divide the exponent by 2
            exponent /= 2;

            // Square the base (result)
            result.multiply(result);
        }

        // If the base (this) was negative and the exponent was even, make the result positive
        if (isNegativeBase && !isNegativeExponent && this.number.get(0) != 0) {
            this.sign = 1;
        }
    }
}
