import java.util.Scanner;

public class KthLargest {

    public static void main(String args[]){

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]= new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        kLargest(arr,k);
        System.out.println(arr[k-1]);
    }

    private static void kLargest(int[] arr, int k) {

        quickSort(arr,0,arr.length-1,k);

    }

    private static void quickSort(int[] arr, int st, int en, int k) {

        if(st<en){
            int pivot=arr[en];
            int i=st;
            int j=en;
            while(i<j){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                    if(arr[i]==pivot)
                        j--;
                    else
                        i++;
                }else{
                    j--;
                }
            }
            swap(arr,i+1,en);

            if(i==k-1)
                return;

            if(i<k-1)
                quickSort(arr,i+1,en,k);

            quickSort(arr,st,i-1,k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

}
