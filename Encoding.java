import java.util.Scanner;

public class Encoding {

    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        printEncoding(s,"");

    }

    private static void printEncoding(String s, String ans) {

        if(s.length()==0){
            System.out.println(ans);
            return;
        }

        if(s.length()>0 && s.charAt(0)!='0'){
            char c = (char) (s.charAt(0) + 48);
            printEncoding(s.substring(1),ans+c);
        }

        if(s.length()>1 && s.charAt(0)!='0'){
           int n = Integer.parseInt(s.substring(0,2));
           if(n<27) {
               char code = (char) ('a' + n - 1);
               printEncoding(s.substring(2), ans + code);

           }
        }
    }

}
