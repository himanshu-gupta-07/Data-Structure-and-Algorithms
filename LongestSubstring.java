import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstring {
    public static void main(String str[]){
        //Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        System.out.println(findLongestSubString("abcabcdsdejnvjenkfjsdaa"));
    }

    //Naive Approach - O(n2) time and O(n) space
//    private static int findLongestSubString(String s) {
//
//        int len= s.length();
//
//        if(s==null || len == 0)
//            return 0;
//
//        if(len<2)
//            return 1;
//
//        int i=0;
//        int j=i+1;
//
//        HashSet<Character>set = new HashSet<>();
//        set.add(s.charAt(i));
//        int count=1;
//        int localCount=1;
//
//        while(j<len) {
//            while (j<len && !set.contains(s.charAt(j))) {
//                localCount++;
//                set.add(s.charAt(j));
//                j++;
//            }
//            count= Math.max(localCount,count);
//            while (i<j && j<len && set.contains(s.charAt(j))) {
//                set.remove(s.charAt(i));
//                i++;
//                localCount--;
//            }
//        }
//
//        return count;
//
//    }

    // O(n) - time and space O(n) approach
//    private static int findLongestSubString(String s){
//
//        HashMap<Character,Integer> map = new HashMap<>();
//
//        int i=0;
//        int j=0;
//        int n= s.length();
//        int count=0;
//
//        while(i<n && j<n){
//            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))>=i){
//                i=map.get(s.charAt(j))+1;
//                map.remove(s.charAt(j));
//            }
//            map.put(s.charAt(j),j);
//            j++;
//
//            count = Math.max(count,j-i);
//        }
//        return count;
//    }

    //dp approach space O(1) and time O(n)
    private static int findLongestSubString(String s){

        int charac[]= new int[256];

        int ans=1;
        int i=0;
        int j=0;
        charac[s.charAt(0)]++;

        while(i<s.length()-1) {
            char c = s.charAt(i+1);
            if(charac[c]==0){
                i++;
                char c1= s.charAt(i);
                charac[c1]=1;
                ans = Math.max(ans,i-j+1);
            }else{
                char c2= s.charAt(j);
                charac[c2]--;
                j++;
            }
        }

        return ans;
    }
}
