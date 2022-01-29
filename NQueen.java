import java.util.Scanner;

public class NQueen {
    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]= new int[n][n];
        setQueens(arr,n,0);

    }

    public static boolean setQueens(int arr[][], int n, int i){

        if(i==n){
            printArr(arr,n);
            return true;
        }

        for(int j=0;j<n;j++){
            if(isValid(arr,i,j,n)){
                arr[i][j]=1;
                if(setQueens(arr,n,i+1))
                    return true;
                arr[i][j]=0;
            }
        }

        return false;
    }

    private static void printArr(int[][] arr, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] arr, int i, int j, int n) {
        for(int k=0;k<i;k++){
            if(arr[k][j]==1)
                return false;
        }
        int a=i;
        int b=j;
        while(i>=0 && j>=0){
            if(arr[i][j]==1)
                return false;
            i--;
            j--;
        }
        i=a;
        j=b;
        while(i>=0 && j<n){
            if(arr[i][j]==1)
                return false;
            i--;
            j++;
        }
        return true;
    }
}
