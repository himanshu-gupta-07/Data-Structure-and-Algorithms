import java.util.Scanner;
import java.util.Stack;

public class FindTriplet{
    public static void main(String str[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(findTriplet(arr));
    }

    private static boolean findTriplet(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int h1= Integer.MAX_VALUE;
        int h3= Integer.MIN_VALUE;

        for(int i=arr.length-1;i>=0;i--){

            h1=arr[i];

            while(!st.empty() && st.peek()<h1){
                h3=st.peek();
                st.pop();
            }

            st.push(h1);

            if(h1<h3)
                return true;
        }

        return false;
    }
}