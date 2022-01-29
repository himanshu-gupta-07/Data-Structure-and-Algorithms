import java.util.Scanner;

public class InversionCount {
    private static int count=0;

    public static void main(String args[]){
        int n;
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        int arr[]= new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        inversionCount(arr,0,n-1);
        System.out.println(count);
    }


    public static int finalCount(int arr[], int st, int en){

        int localCount=0;

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
        for(i= 0; i < n1; i++){
            j=0;
            while(j < n2 && temp1[i] > (2 * temp2[j])){
                j++;
                localCount += 1;
            }
        }
        i=0;
        j=0;
        while(i<n1 && j<n2){
            if(temp1[i]<temp2[j])
                arr[k++]=temp1[i++];
            else{
                arr[k++]=temp2[j++];
            }
        }
        while(i<n1){
            arr[k++]=temp1[i++];
        }

        while(j<n2){
            arr[k++]=temp2[j++];
        }
        return localCount;
    }

    public static void inversionCount(int arr[], int st, int en){

        if(st<en){
            int mid= (st+en)/2;
            inversionCount(arr,st,mid);
            inversionCount(arr,mid+1,en);
            count+=finalCount(arr,st, en);
        }

    }
}
