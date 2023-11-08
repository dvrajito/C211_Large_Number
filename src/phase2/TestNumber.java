/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru, Gavin Power, Brandon Jones, Charlie Kinnett, Tiffany Leister, Katie DeLucio, Madeline Abbott, Daniel Guernsey, Jiya Stroder, Jennifer Rose
 * Class: LargeNumber
 * A test class for the class LargeNumber.
 ************************************************************/

package phase2;

import java.util.Scanner;

public class TestNumber {

    // A quick test for the methods so far
    public static void main(String[] args) {

        // testConstructorInt();
        testPower();
        // testMultiply();
        // testCleanTrail();
        // testCopy();
        // testMultiply();
        // testSubtract(350, 275);
        // testSubtract(350, -275);
        // testSubtract(350, 350);
        testMultiply();
        testDivide();
        // testPercent();

        /*********************************************/
        // Testing using compareTo method
        // Test 1: Compare smaller number to bigger
        // testCompare(123456789, 987654321);
        // // Test 2: Compare bigger number to smaller
        // testCompare(465798132, 1500);
        // // Test 3: Compare equal numbers
        // testCompare(97654, 97654);
        // // Test 4: Comparison using negative numbers
        // testCompare(-123456, -456789);
        // // Test 5: Comparison with a negative number
        // // as first input
        // testCompare(-4569, 4569);
        // // Test 6: Test while 2nd number is negative
        // testCompare(123456, -456123);
        // // Test 7: Comparison using leading zeros
        // testCompare(00005, 00000005);
        /*********************************************/
    }

    // Team 6 - test for the multiplication
    public static void testMultiply() {
        LargeNumber n = new LargeNumber(-25123);
        LargeNumber o = new LargeNumber(-572148);
        n.multiply(o);
        System.out.println("The multiplied number is: " + n);
    }

    // Team 5: Jack Ventura, Titus Duncan, Matthew Molewyk
    // Method to test the Divide method in the LargeNumber class
    public static void testDivide() {
        LargeNumber dividend = new LargeNumber(50000);
        LargeNumber divisor = new LargeNumber(25000);
        dividend.divide(divisor);

        // print statements for the value of quotient and its sign
        System.out.println("The quotient is: " + dividend);
        System.out.println("The sign of the quotient is " + divisor.sign);
    }

    // Team 7: Daniel Guernsey, Jiya Stroder, Jennifer Rose
    public static void testPercent() {
        LargeNumber n = new LargeNumber(994823674);
        LargeNumber m = new LargeNumber(25567);
        n.percent(m);
        System.out.println("Test Percent: " + n);
    }

    // Team 8: Gavin Power, Brandon Jones, Charlie Kinnett
    // This method tests the cleanTrail method in LargeNumber
    public static void testCleanTrail() {
        LargeNumber test = new LargeNumber("0000015600");
        System.out.println(test);
        test.cleanTrail();
        System.out.println(test);
    }

    /*
     * Team 2: Amstrong Akendung, Alyssa Martinez, Mario Garcilazo
     * Test method to test subtraction Logic
     */
    public static void testSubtract(int int1, int int2) {
        LargeNumber num1 = new LargeNumber(int1);
        LargeNumber num2 = new LargeNumber(int2);
        // Subtract num2 from num1
        num1.subtract(num2);
        System.out.println("ANS: "+num1);
    }

    public static void testString() {
        Scanner scan = new Scanner(System.in);
        String test;

        System.out.println("Enter a string");
        test = scan.nextLine();

        // Created a LargeNumber object using users entry
        LargeNumber testingString = new LargeNumber(test);
        System.out.println(testingString);
    }

    // Tests the constructor with an integer
    public static void testConstructorInt() {
        LargeNumber n = new LargeNumber(628451);
        System.out.println("The number is: " + n); // test toString
        System.out.println("The number has " + n.getSize() + " digits.");
        if (n.getSign() > 0)
            System.out.println("The number is positive.");
        else
            System.out.println("The number is negative.");
        System.out.println(n.toInt());
    }

    // Tests the copy constructor
    public static void testCopy() {
        LargeNumber n1, n2;
        n1 = new LargeNumber(46274);
        n2 = new LargeNumber(n1);
        n2.number.set(1, 3);
        n2.number.add(5);
        System.out.println("n1: " + n1 + " n2: " + n2);
    }

    // Team 1: Katie Delucio, Maddie Abbott, Tiffany Leister
    // Addition of Large Number Test
    // Output initial value and new value after addition
    public static void testAdd() {
        LargeNumber addTestOne = new LargeNumber(-20);
        LargeNumber addTestTwo = new LargeNumber(3);
        System.out.println("The current value of the number is " + addTestOne);
        addTestOne.add(addTestTwo);
        System.out.println("The new value of the number is " + addTestOne);
    }

    // Method for testing compareTo function
    public static void testCompare(int testInt1, int testInt2) {
        LargeNumber num1 = new LargeNumber(testInt1);
        LargeNumber num2 = new LargeNumber(testInt2);

        int result = num1.compareTo(num2);

        if (result == 1) {
            System.out.println(num1 + " is greater than " + num2);
        } else if (result == -1) {
            System.out.println(num1 + " is smaller than " + num2);
        } else {
            System.out.println(num1 + " is equal to " + num2);
        }
    }
    
     // Team 9: Gaven Van Skyock, Thomas Polega
    public static void testPower() {
        LargeNumber base = new LargeNumber(3); // Set the base to a positive number
        LargeNumber exponent = new LargeNumber(3); // Set the exponent to a positive number

        System.out.println("Base: " + base);
        System.out.println("Exponent: " + exponent);

        base.power(exponent);

        System.out.println("Result: " + base);

        // You can add more test cases with different bases and exponents.
    }
  
}
