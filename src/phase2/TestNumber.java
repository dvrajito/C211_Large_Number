/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru
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
    }

}
