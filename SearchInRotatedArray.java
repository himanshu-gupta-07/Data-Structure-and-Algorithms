import java.util.Scanner;

public class SearchInRotatedArray {

    public static void main(String str[]){

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        int key=sc.nextInt();

        System.out.print("Index of key : ");
        System.out.println(searchInrotatedArray(arr,0,n-1,key));
    }

    private static int searchInrotatedArray(int[] arr, int st, int en,int  key) {

        while(st<=en){

            int mid=(st+en)/2;

            if(arr[mid]==key)
                return mid;

            if(arr[st]<=arr[mid]){
                if(arr[st]<=key && arr[mid]>key)
                    en=mid-1;
                else
                    st=mid+1;
            }else{
                if(arr[mid]<key && arr[en]>=key)
                    st=mid+1;
                else
                   en=mid-1;
            }
        }


        return -1;
    }
}
