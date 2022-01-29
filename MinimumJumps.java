import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class MinimumJumps {

    public static void main(String str[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int dp[]= new int[n+1];
        for(int i=0;i<n;i++)
            dp[i]=Integer.MAX_VALUE;

        System.out.println(minJumps(arr,0,n-1,dp));
    }

    private static int minJumps(int[] arr,int i,int n,int dp[]) {

        if(i>=n)
            return 0;

        if(dp[i]!=Integer.MAX_VALUE)
            return dp[i];

        for(int j=i+1;j<=i+arr[i];j++)
            dp[i]=1+Math.min(dp[i],minJumps(arr,j,n,dp));

        return dp[i];

    }
}
