import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class NonRepeatingElementFromFirst {
    public static void main(String args[]){
        String l;
        Scanner sc= new Scanner(System.in);
        l=sc.next();
        System.out.println(nonrepeatingCharacter(l));
    }
    static char nonrepeatingCharacter(String S)
    {

        int len= S.length();
        LinkedList<Character> ll= new LinkedList<Character>();
        HashSet<Character> map= new HashSet<Character>();
        for(int i=0;i<len;i++){
            if(!map.contains(S.charAt(i))){
                map.add(S.charAt(i));
                ll.add(S.charAt(i));
            }else{
                ll.removeFirstOccurrence(S.charAt(i));
            }
        }

        if(ll.size()!=0)
            return ll.get(0);

        return '$';

    }
}
