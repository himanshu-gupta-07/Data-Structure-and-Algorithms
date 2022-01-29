import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QuickSort {

    public static void main(String args[]){
        int n;
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        int arr[]= new int [n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int x: arr)
            System.out.print(x+ " ");

        quicksort(arr,0,n-1);

        System.out.println();

        for(int x: arr)
            System.out.print(x+ " ");
    }

    private static void quicksort(int[] arr,int st, int en) {

        if(st<en){

            //partition
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
            //
//            ArrayList<Integer>al= new ArrayList<>();
////            al.
//            PriorityQueue<Integer>pq = new PriorityQueue<>();
//            pq.p
            quicksort(arr,st,j-1);
            quicksort(arr,j+1,en);
        }


    }

    private static void swap(int []arr,int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

}
