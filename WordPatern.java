import java.util.ArrayList;
import java.util.HashMap;

public class WordPatern {

    public static void main(String arg[]){
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
    public static boolean wordPattern(String pattern, String s) {

        //making of Array of words
        ArrayList<String> arr= new ArrayList<String>();
        String word="";

        for(int i=0;i<s.length() ;i++){
            if(s.charAt(i)==' '){
                arr.add(word);
                word="";
            }else{
                word+=s.charAt(i);
            }
        }

        arr.add(word);
        int len= pattern.length();
        if(arr.size()!= len)
            return false;

        //Comparing Array of words to pattern
        HashMap<Character, String> map = new HashMap<Character, String>();

        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                String val1= map.get(pattern.charAt(i));
                String val2= arr.get(i);
                if(!val1.equals(val2))
                    return false;
            }else{
                if(map.containsValue(arr.get(i)))
                    return false;
                map.put(pattern.charAt(i), arr.get(i));
            }
        }

        return true;

    }
}
