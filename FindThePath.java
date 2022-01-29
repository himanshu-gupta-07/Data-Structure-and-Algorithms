import java.util.ArrayDeque;
import java.util.Queue;

public class FindThePath {

    static class Pair1{
        int x;
        int y;
    }
    static int visited[][]= new int[10][10];
    public static void main(String arg[]){

        int mat[][] =

                {

//                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//
//                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//
//                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
//
//                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
//
//                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
//
//                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
//
//                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
//
//                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
//
//                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//
//                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 }

                        { 1, 1, 1, 1},
                        { 0, 1, 1, 1},
                        { 0, 0, 1, 0},
                        { 1, 0, 1, 1}


                };


        System.out.print(findPath(mat,0,0,3,3));
    }

    public static boolean findPath(int mat[][], int x1, int y1, int x2, int y2){

        ArrayDeque<Pair1> q= new ArrayDeque<Pair1>();
        Pair1 p= new Pair1();
        p.x=x1;
        p.y=y1;

        q.add(p);
        visited[0][0]=1;
        while(!q.isEmpty()){

            p= q.poll();
            int i=p.x;
            int j=p.y;

            if(i==x2 && j==y2)
                return true;

            if(isValid(mat, i+1,j) && visited[i+1][j]==0){
                Pair1 p1= new Pair1();
                p1.x=i+1;
                p1.y=j;
                q.add(p1);
                visited[i+1][j]=1;
            }

            if(isValid(mat, i-1,j) && visited[i-1][j]==0 ){
                Pair1 p1= new Pair1();
                p1.x=i-1;
                p1.y=j;
                q.add(p1);
                visited[i-1][j]=1;
            }

            if(isValid(mat, i,j-1) && visited[i][j-1]==0 ){
                Pair1 p1= new Pair1();
                p1.x=i;
                p1.y=j-1;
                q.add(p1);
                visited[i][j-1]=1;
            }

            if(isValid(mat, i,j+1) && visited[i][j+1]==0 ){
                Pair1 p1= new Pair1();
                p1.x=i;
                p1.y=j+1;
                q.add(p1);
                visited[i][j+1]=1;
            }

        }

        return false;

    }

    private static boolean isValid(int mat[][], int i, int j) {

        if(i>3 || i<0 || j<0 || j>3 )
            return false;
        else if(mat[i][j]==0){
            return false;
        }

        return true;
    }
}
