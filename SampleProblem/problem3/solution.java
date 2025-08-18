package problem3;
public class solution {
    // task 1 -> recursive with spaces within each character
    public static void printWithSpaces(String y){
        System.out.print(y.charAt(0) + " ");
        if(y.length() > 1)printWithSpaces(y.substring(1));
    }

    public static String weave(String a,String b){
        if(a.length() > 1 && b.length() > 1){
            return String.valueOf(a.charAt(0)) + String.valueOf(b.charAt(0)) + weave(a.substring(1),b.substring(1));
        }else if(a.length() == 1){
            return a + b;
        }else if(b.length() == 1){
            return String.valueOf(a.charAt(0)) + b + a.substring(1);
        }else{
            return a + b;
        }
    }
    public static void main(String[] args){
        System.out.println("Print with spaces test(FikriGantengBanget) : ");
        printWithSpaces("FikriGantengBanget");
        System.out.println();

        System.out.println("Print with weaves(aaaa and bbbb) : ");
        System.out.println(weave("aaaa","bbbb") + "\n");

        System.out.println("Print with weaves(hello and world) : ");
        System.out.println(weave("hello", "world") + "\n");

        System.out.println("Print with weaves(\"\" and \"\") : ");
        System.out.println(weave("", "") + "\n");
    }
}
