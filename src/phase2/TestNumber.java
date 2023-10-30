/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru, Gavin Power, Brandon Jones, Charlie Kinnett, Tiffany Leister, Katie DeLucio, Madeline Abbott,
 * Class: LargeNumber
 * A test class for the class LargeNumber.
 ************************************************************/

package phase2;
import java.util.Scanner;

public class TestNumber {

    // A quick test for the methods so far
    public static void main(String[] args) {
        
        LargeNumber n = new LargeNumber(628451);
        System.out.println("The number is: " + n); // test toString
        System.out.println("The number has " + n.getSize() + " digits.");
        if (n.getSign() > 0)
            System.out.println("The number is positive.");
        else
            System.out.println("The number is negative.");
        //testMultiply();
//        testCleanTrail();
        testCopy();
        testMultiply();
        testSubtract(350, 275);
        testSubtract(350, -275);
        testSubtract(350, 350);
    }

    public static void testMultiply() {
        LargeNumber n = new LargeNumber(53894);
        LargeNumber o = new LargeNumber(58348);
        n.multiply(o);
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
    }

    public static void testString() {
    	Scanner scan = new Scanner (System.in);
    	String test;

    	System.out.println("Enter a string");
    	test = scan.nextLine();

    	//Created a LargeNumber object using users entry
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
    //Team 1: Katie Delucio, Maddie Abbott, Tiffany Leister
    //Addition of Large Number Test
    //Output initial value and new value after addition
    public static void testAdd() {
    	LargeNumber addTestOne = new LargeNumber(12345);
    	LargeNumber addTestTwo = new LargeNumber(1111);
    	System.out.println("The current value of the number is " + addTestOne);
    	addTestOne.add(addTestTwo);
    	System.out.println("The new value of the number is " + addTestOne);
    }
}
