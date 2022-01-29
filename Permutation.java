import java.util.Scanner;

public class Permutation {

    private static int count=0;

    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        printPermutations(s,"");
        System.out.print(count);
    }

    private static void printPermutations(String s,String ans) {

        if(s.length()==0){
            count++;
            System.out.println(ans);
            return;
        }

       for(int i=0;i<s.length();i++){
           char c= s.charAt(i);
           String res = s.substring(0,i)+s.substring(i+1);
           printPermutations(res,ans+c);
       }

    }

}
