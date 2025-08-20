/*
 ***** THIS FILE IS FOR TESTING PURPOSES ONLY. *****
 * 
 * Put the final versions of your methods for problem 2 
 * in your ps1_partI file.
 * 
 * Do NOT submit them in this file.
 */
package ProblemSet1.ShortAnswerProblem;
import java.util.*;    // for access to the Arrays class

public class Problem2Test {
    /*** Put your methods for problems 2a and 2b below ***/
    public static boolean isSorted(int[] arr) throws IllegalArgumentException {
        if (arr == null)
            throw new IllegalArgumentException("Array cannot be null\n");
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return false;
    }

    public static void scale(int[] arr, int factor) {
        for(int i = 0; i < arr.length; i++){
            arr[i] *= factor;
        }
    }
    /*
     * This main method includes several tests for your methods.
     * 
     * It will not compile until you have added correct definitions
     * for both of the methods.
     * 
     * We encourage you to add additional tests as well.
     */ 
    public static void main(String[] args) {
        int[] values = {1, 2, 4, 6, 8, 10};
        System.out.print("isSorted() for an array that is sorted: ");
        System.out.println(isSorted(values));
        System.out.println();

        values[3] = 20;


        System.out.print("isSorted() for an array that is *not* sorted: ");
        System.out.println(isSorted(values));
        System.out.println();

        int[] values2 = {1, 2, 4, 6, 8, 10};
        System.out.println("values2 array before scaling:");
        System.out.println(Arrays.toString(values2));
        System.out.println();

        scale(values2, 3);

        System.out.println("values2 array after scale(values2, 3):");
        System.out.println(Arrays.toString(values2));
        System.out.println();

        
    }
}