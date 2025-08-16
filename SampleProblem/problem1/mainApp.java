package problem1;
public class mainApp{
    public static void swapPairs(int[] values){
        for(int i = 0; i < values.length - 1; i+=2){
            int tmp = values[i];
            values[i] = values[i + 1];
            values[i + 1] = tmp;
        }
    }
    public static void main(String[] args){
        int[] values = {0, 2, 4, 6, 8, 10};
        swapPairs(values);
        for(int val : values){
            System.out.print(val + " ");
        }
    }
}