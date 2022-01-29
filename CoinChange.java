import java.util.Scanner;

public class CoinChange {
    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int nums[]= new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();
        int amount=sc.nextInt();
        System.out.println(coinChange(nums,amount));

    }

    public static int coinChange(int[] coins, int amount) {

        if(amount==0)
            return 0;


        int n= coins.length;

        if(n==1 && amount%coins[0]!=0)
            return -1;

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(amount-coins[i]>=0)
                min=1+Math.min(min,coinChange(coins,amount-coins[i]));
        }

        if(min==Integer.MAX_VALUE)
            return -1;

        return min;
    }
}
