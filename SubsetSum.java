import java.util.Scanner;

public class SubsetSum {

    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        int sum=sc.nextInt();


        System.out.println(noOfSubsets(arr,0,n-1,sum));
    }

    private static int noOfSubsets(int[] arr, int st, int en,int sum) {


        if(sum==0){
            return 1;
        }
        if(sum<0 || en<st)
            return 0;

        return noOfSubsets(arr,st+1,en,sum-arr[st]) + noOfSubsets(arr,st+1,en,sum);
    }

}
