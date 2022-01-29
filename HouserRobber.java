import java.util.Scanner;

public class HouserRobber {
    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);

        int arr[]={114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};

        System.out.println(utils(arr,0,0));
        System.out.println(dpUtils(arr));
    }

    //recursive solution
    private static int utils(int[] nums, int i, int amount) {
        if(i>nums.length-1)
            return amount;

        if(i==nums.length-1)
            return amount+nums[i];

        return Math.max(utils(nums,i+1,amount), utils(nums,i+2,amount+nums[i]));


    }

    //DP solution
    private static int dpUtils(int []nums){

        int n= nums.length;
        if(n==1)
            return nums[0];

        int dp[]=new int[n];

        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);

        for(int i=2;i<n;i++){

            dp[i]=dp[i-2]+nums[i];
            dp[i]=Math.max(dp[i-1],dp[i]);

        }

        return Math.max(dp[n-1],dp[n-2]);
    }

}
