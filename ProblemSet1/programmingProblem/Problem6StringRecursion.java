package ProblemSet1.programmingProblem;
class Problem6StringRecursion{
    // Task 1
    public static String reflect(String inp){
        if(inp.length() <= 1){
            return inp + inp;
        }else{
            return inp.charAt(0) + reflect(inp.substring(1)) + inp.charAt(0);
        }
    }
    // Task 2
    public static int numDiff(String a, String b){
        if(a.length() <= 1 || b.length() <= 1){
            int val = 0;
            if(a.length() != 0 && b.length() != 0 && a.charAt(0) != b.charAt(0)) val = 1;
            return val + Math.abs(a.length() - b.length()); 
        }else{
            int val = 0;
            if(a.charAt(0) != b.charAt(0)) val = 1;
            return val + numDiff(a.substring(1),b.substring(1));
        }
    }


    //task 3
    public static int indexOf(char ch, String str){
        if(str.length() == 0){
            return -1;
        }else if(ch == str.charAt(0)){
            return 0;
        }
        else{
            if(indexOf(ch,str.substring(1)) > -1){
                return 1 + indexOf(ch,str.substring(1));
            }else{
                return indexOf(ch,str.substring(1));
            }
        }
    }


    //task 4
    public static String trim(String str){
        if(str.length() == 0){
            return str;
        }else{
            int r = str.length() - 1;
            if(r == 0){
                if(str.charAt(0) == ' '){
                    return "";
                }else{
                    return str;
                }
            }
            if(str.charAt(0) == ' ' && str.charAt(r) == ' '){
                return trim(str.substring(1,r));
            }else if(str.charAt(0) == ' '){
                return trim(str.substring(1));
            }else if(str.charAt(r) == ' '){
                return trim(str.substring(0,r));
            }else{
                return str;
            }
        }
    }
    public static void main(String[] args){
        // testing reflect string
        // all correct
        System.out.println(reflect("method"));
        System.out.println(reflect("abc"));
        System.out.println();

        // testing numDiff
        // all correct
        System.out.println(numDiff("alien","allen"));
        System.out.println(numDiff("allien", "alone"));
        System.out.println(numDiff("same", "same"));
        System.out.println(numDiff("same","sameness"));
        System.out.println(numDiff("some","sameness"));
        System.out.println(numDiff("","abc"));
        System.out.println(numDiff("abc",""));
        System.out.println();

        // testing indexOf
        // all correct
        System.out.println(indexOf('b',"Rabbit"));
        System.out.println(indexOf('P',"Rabbit"));
        System.out.println();

        //testing trim
        //all correct
        System.out.println(trim("    Hello World    "));
        System.out.println(trim("recursive  "));
        System.out.println();

    }
}