import java.util.Scanner;

public class FrequencyCount {

    public static void main(String args[]){
        int n;
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        int arr[]= new int [n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int k= sc.nextInt();

        System.out.println(frequency(arr, n, k));

    }

    public static int frequency(int arr[], int n, int k){
        int st=0;
        int en=n-1;
        int flag=0;
        while(st<=en){
            int m=(st+en)/2;
            if(arr[m]==k){
                st=lowerBound(arr,st,m,k);
                en=upperBound(arr,m,en,k);
                flag=1;
                break;
            }else if(arr[m]<k)
                st=m+1;
            else
                en=m-1;
        }
        if(flag==0)
            return 0;
        return en-st+1;
    }

    private static int upperBound(int[] arr, int m, int en, int k) {
        int st=m;
        while(st<=en){
            int mid=(st+en)/2;
            if(arr[mid]==k){
                m=mid;
                st=mid+1;
            }else if(arr[mid]<k){
                st=mid+1;
            }else{
                en=mid-1;
            }
        }


        return m;
    }

    private static int lowerBound(int[] arr, int st, int m, int k) {
        int en=m;
        while(st<=en){
           int mid=(st+en)/2;
           if(arr[mid]==k){
               m=mid;
               en=mid-1;
           }else if(arr[mid]<k){
               st=mid+1;
           }else{
               en=mid-1;
           }
        }

        return m;
    }
}
