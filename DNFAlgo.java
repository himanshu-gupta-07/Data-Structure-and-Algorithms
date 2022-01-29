import java.util.Scanner;

public class DNFAlgo {
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

        dnf(arr,0,n-1);

        System.out.println();
        for(int x: arr)
            System.out.print(x+ " ");
    }

    private static void dnf(int[] arr, int l, int h) {
        int m=l;
        int n=h;
        while(m<n && m<h){
            if(arr[m]==0){
                swap(arr,m,l);
                m++;
                l++;
            }else if(arr[m]==2){
                swap(arr,m,h);
                h--;
            }else{
                m++;
            }
        }
        return;
    }

    private static void swap(int[] arr, int m, int l) {
        int t=arr[m];
        arr[m]=arr[l];
        arr[l]=t;
    }
}
