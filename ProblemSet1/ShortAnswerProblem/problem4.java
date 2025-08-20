package ProblemSet1.ShortAnswerProblem;

import java.util.Arrays;

public class problem4 {
    public static void printReverse(int[] arr, int i){
        if(arr.length == 1){
            System.out.print(arr[0] + " ");
        }else{
            printReverse(Arrays.copyOfRange(arr,1, i), i - 1);
            System.out.print(arr[0] + " ");
        }
    }
    public static void main(String[] args){
        int arr[] = {1,4,5,2,1,3};
        System.out.print("Print without reverse : ");
        for(int i : arr) System.out.print(i + " ");
        System.out.println(" \n");
        System.out.print("Print with reverse : ");
        printReverse(arr,arr.length);
    }
}

