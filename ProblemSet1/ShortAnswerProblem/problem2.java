package ProblemSet1.ShortAnswerProblem;
public class problem2 {
    public static boolean isSorted(int[] arr) throws IllegalArgumentException{
        if(arr == null) throw new IllegalArgumentException("Array cannot be null\n");
        int size = arr.length;
        for(int i = 1; i < size; i++){
            if(arr[i] < arr[i - 1]) return false;
        }
            System.out.println("Error : Cannot get a length for null value");
        
        return false;
    }
    public static void scale(int[] arr, int factor){
        for(int i = 0; i < arr.length; i++){
            arr[i] *= factor;
        }
    }
    public static void main(String[] args){
        int arr[] = {1,2,2,2,3,4};
        int arr2[] = {0,1,3,0,2,3};

        if(isSorted(arr)) System.out.println("arr is sorted...");
        else System.out.println("arr is not sorted...");
        System.out.println();

        if(isSorted(arr2)) System.out.println("arr2 is sorted...");
        else System.out.println("arr2 is not sorted...");

        System.out.println();

        if(isSorted(null)) System.out.println("The array is sorted....");
        else System.out.println("The array is not sorted...");


        
    }
}
