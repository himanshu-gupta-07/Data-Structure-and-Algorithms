import java.util.ArrayList;
import java.util.HashMap;

public class InterleavedStrings {
    public static void main(String args[]){

        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
    static class Node{
        int index;
        boolean visited;
        Node(int in, boolean v){
            index=in;
            visited=v;
        }
    }

    private static HashMap<Character, ArrayList<Node>> map = new HashMap<Character,ArrayList<Node>>();

    public static boolean checkInterLeave(String s1, String s2){

        int in=-1;
        boolean check=false;
        ArrayList<Node> l= new ArrayList<Node>();

        for(int i=0;i<s1.length();i++){
            char c= s1.charAt(i);
            if(!map.containsKey(c))
                return false;

            l= new ArrayList<Node>();
            l= map.get(c);
            check =false;
            for(int j=0;j<l.size();j++){
                Node no= l.get(j);
                if(!no.visited && no.index>in){
                    in=no.index;
                    no.visited=true;
                    check=true;
                    break;
                }
            }
            if(!check)
                return false;

        }

        in=-1;
        //check=false;
        for(int i=0;i<s2.length();i++){

            char c= s2.charAt(i);
            if(!map.containsKey(c))
                return false;

            l= new ArrayList<Node>();
            l= map.get(c);
            check =false;
            for(int j=0;j<l.size();j++){
                Node no= l.get(j);
                if(!no.visited && no.index>in){
                    in=no.index;
                    no.visited=true;
                    check=true;
                    break;
                }
            }
            if(!check)
                return false;

        }

        return check;

    }

    public static boolean isInterleave(String s1, String s2, String s3) {


        for(int i=0;i<s3.length();i++){
            char c= s3.charAt(i);
            if(!map.containsKey(c))
                map.put(c,new ArrayList<Node>());
            Node n= new Node(i,false);
            map.get(c).add(n);
        }
        return checkInterLeave(s1,s2);

    }
}
