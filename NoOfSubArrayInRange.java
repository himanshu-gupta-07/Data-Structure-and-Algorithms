public class NoOfSubArrayInRange {
    public static void main(String str[]){

        int arr[]= {3,4,1};
        System.out.println(noOfSubarray(arr,2,4));
    }

    public static int noOfSubarray(int arr[],int L, int R){

        int res=0;
        int in=0;
        int ex=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>R){
               res+= subarrays(in)-subarrays(ex);
               in=0;
               ex=0;
            }else if(arr[i]<L){
                in++;
                ex++;
            }else{
                res-= subarrays(ex);
                ex=0;
                in++;
            }
        }

        res+=subarrays(in)-subarrays(ex);

        return res;
    }

    private static int subarrays(int n) {
        return n*(n+1)/2;
    }
}
