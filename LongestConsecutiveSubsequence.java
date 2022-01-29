import java.util.Iterator;
import java.util.TreeSet;

public class LongestConsecutiveSubsequence {
    public static void main(String str[]){
        int arr[]={0,-1};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {

        int n= nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        TreeSet<Integer> set= new TreeSet<Integer>();

        for(int i: nums){
            if(!set.contains(i))
                set.add(i);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
