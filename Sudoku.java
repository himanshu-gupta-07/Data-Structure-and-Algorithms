import java.util.Scanner;

public class Sudoku {

    public static void main(String str[]){

        Scanner sc= new Scanner(System.in);

        int arr[][]= {
                {8,6,0,0,2,0,0,0,0},
                {0,0,0,7,0,0,0,5,9},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,6,0,8,0,0},
                {0,4,0,0,0,0,0,0,0},
                {0,0,5,3,0,0,0,0,7},
                {0,0,0,0,0,0,0,0,0},
                {0,2,0,0,0,0,6,0,0},
                {0,0,7,5,0,9,0,0,0}
        };

        sudokuSolver(arr,0,0);


    }
    public static boolean isSafe(int[][] arr, int i, int j,  int no) {

        //row col check
        for(int k=0;k<9;k++){
            if(arr[i][k]==no || arr[k][j]==no)
                return false;
        }

        //grid check
        int sx= (i/3)*3;
        int sy= (j/3)*3;
        for(int k=sx;k<sx+3;k++){
            for(int l=sy;l<sy+3;l++) {
                if (arr[k][l] == no)
                    return false;
            }
        }
        return true;
    }

    public static void print(int[][] arr) {
        System.out.println("---Solution---");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean sudokuSolver(int[][] arr,  int i, int j) {

        //base
        if(i==9){
            print(arr);
            return true;
        }

        if(j==9){
            return sudokuSolver(arr,i+1,0);
        }

        //recursive case
        if(arr[i][j]!=0){
            return sudokuSolver(arr,i,j+1);
        }


        //check if no is safe or not
        for(int no=1;no<=9;no++){
           if(isSafe(arr,i,j,no)){
                arr[i][j]=no;
                if(sudokuSolver(arr,i,j+1)){
                    return true;
                }
           }

        }
        arr[i][j]=0;
        return false;
    }
}
