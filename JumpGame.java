import java.util.ArrayDeque;
import java.util.Scanner;

public class JumpGame {

    static class Node{
        int in;
        int arrV;
        int jumpV;
        String path;

        Node(int i, int av, int jv, String p){
            this.in=i;
            this.arrV=av;
            this.jumpV=jv;
            this.path=p;
        }
    }

    public static void main(String str[]){

        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        allPath(arr,n);
    }

    public static void allPath(int arr[], int n){

        Integer dp[]= new Integer[n];
        dp[n-1]=0;

        for(int i=n-2;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i+1; j<=i+arr[i] && j<n ;j++){
                if(dp[j]!=null){
                    min=Math.min(min,dp[j]);
                }
            }
            if(min!=Integer.MAX_VALUE)
                dp[i]=1+min;
        }

        System.out.println(dp[0]);

        ArrayDeque<Node> q= new ArrayDeque<Node>();

        q.add(new Node(0,arr[0],dp[0],0+""));

        while(!q.isEmpty()){
            Node val= q.removeFirst();

            if(val.jumpV==0)
                System.out.println(val.path);

            for(int i=1;i<=i+arr[i] && i+arr[i]<n ;i++){
                int c=val.in+i;
                if(dp[c]!=null && dp[c]==dp[i-1]-1)
                    q.add(new Node(c,arr[c],dp[c],"->"+val.path+c));
            }
        }
    }


}
