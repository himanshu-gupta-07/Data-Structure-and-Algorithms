import java.util.Scanner;

public class Subsets {

    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        printSubsets("",s);
    }

    private static void printSubsets(String str,String s) {

        if(s.length()==0){
            System.out.println("**"+str+"**");
            return;
        }


        printSubsets(str+s.charAt(0),s.substring(1,s.length()));
        printSubsets(str,s.substring(1,s.length()));

    }
}
