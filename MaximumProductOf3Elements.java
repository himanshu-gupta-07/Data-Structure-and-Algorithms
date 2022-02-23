public class MaximumProductOf3Elements {
    public static void main(String str[]){

        int arr[]= {-9,-8,5,6,7};

        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;

        for(int i:arr){

            if(i<=min1){
                min2=min1;
                min1=i;
            }else if(i<=min2){
                min2=i;
            }

            if(i>=max1){
                max3=max2;
                max2=max1;
                max1=i;
            }else if(i>=max2){
                max3=max2;
                max2=i;
            }else if(i>=max3){
                max3=i;
            }

        }

        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
