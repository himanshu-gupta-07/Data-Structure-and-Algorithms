/* Kadane Algorithm - Maximum sum of contigous subarray
* case1: -2,1,-3,4,-1,2,1,-5,4
* sum = 6
* currSum = 5
*
* */


public class KadaneALgo {

    public static int maxContigousSubarray(int arr[]){
        int sum= Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<arr.length;i++){

            currSum+=arr[i];

            if(currSum>sum)
                sum=currSum;

            if(currSum<0)
                currSum=0;

        }

        return sum;
    }
}
