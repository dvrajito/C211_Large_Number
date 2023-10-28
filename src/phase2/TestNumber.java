/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru, Gavin Power, Brandon Jones, Charlie Kinnett
 * Class: LargeNumber
 * A test class for the class LargeNumber.
 ************************************************************/

package phase2;

public class TestNumber {

    // A quick test for the methods so far
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LargeNumber n = new LargeNumber(628451);
        System.out.println("The number is: " + n); // test toString
        System.out.println("The number has " + n.getSize() + " digits.");
        if (n.getSign() > 0)
            System.out.println("The number is positive.");
        else
            System.out.println("The number is negative."); 
        //testMultiply();
        testCleanTrail();
        testMultiply();
        testSubtraction(350, 275);
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

    public static void testSubtraction(int int1, int int2) {
        LargeNumber num1 = new LargeNumber(int1);
        LargeNumber num2 = new LargeNumber(int2);

        // Subtract num2 from num1
        num1.subtract(num2);
    }

}
