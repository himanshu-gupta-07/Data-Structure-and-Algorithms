import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Subsequence {

    public static void main (String str[]){

        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println(getSubsequence(s));

    }

    public static ArrayList<String> getSubsequence(String s){

        if(s.length()==0){
           ArrayList<String> arr= new ArrayList<>();
           arr.add("");
           return arr;
        }

        char c= s.charAt(0);
        String rs= s.substring(1);

        ArrayList<String> rres = getSubsequence(rs);
        ArrayList<String> mres = new ArrayList<>();

        for(String st:rres){
           mres.add(""+st);
        }

        for(String st:rres){
            mres.add(c+st);
        }

        return mres;
    }
}
