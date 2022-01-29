import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    public static void main(String str[]){
        int arr[]={8,10,4,9,1,3,5,9,4,10};
        System.out.println(deleteAndEarn(arr));
    }

    public static int deleteAndEarn(int[] nums) {

        int n= nums.length;
        if(n==1)
            return nums[0];

        int arr[]= new int[10001];

        for(int i:nums)
            arr[i]+=i;

        int dp[]= new int[10001];

        dp[1]=arr[1];
        dp[2]= Math.max(arr[2],dp[1]);

        for(int i=3;i<=10000;i++){
            if(arr[i-1]!=0){
                dp[i]=dp[i-2]+arr[i];
                dp[i]=Math.max(dp[i],dp[i-1]);
            }else{
                dp[i]=dp[i-1]+arr[i];
            }
        }

        return dp[10000];

    }
}
