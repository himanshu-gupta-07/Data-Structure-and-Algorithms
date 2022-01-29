import java.util.Scanner;

public class MergeSort {

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
        mergesort(arr,0,n-1);

        System.out.println();
        for(int x: arr)
            System.out.print(x+ " ");
    }

    public static  void merge(int []arr, int st, int en){
        int mid= (st+en)/2;
        int n1=mid-st+1;
        int n2=en-mid;
        int temp1[]= new int[n1];
        int temp2[]= new int[n2];

        for(int i=0;i<n1;i++){
            temp1[i]=arr[st+i];
        }
        for(int i=0;i<n2;i++){
            temp2[i]=arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=st;
        while(i<n1 && j<n2){
            if(temp1[i]<temp2[j])
                arr[k++]=temp1[i++];
            else
                arr[k++]=temp2[j++];
        }
        while(i<n1){
            arr[k++]=temp1[i++];
        }

        while(j<n2){
            arr[k++]=temp2[j++];
        }
    }

    public static void mergesort(int []arr,int st,int en){

        if(st<en){
            int mid=(st+en)/2;
            mergesort(arr,st,mid);
            mergesort(arr,mid+1,en);
            merge(arr,st,en);
        }
    }
}
