public class StockBuyOrSell {
    public static void main(String str[]){
        int arr[]= {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfitUtils(int[] prices, int s){

        if(s>prices.length-2)
            return 0;


        int c2=0;

        int max=0;

        for(int i=s;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]) {
                int c1 = prices[i + 1] - prices[i] + maxProfitUtils(prices, i + 2);

                if (max < c1)
                    max=c1;
            }

        }

        c2= maxProfitUtils(prices, s+1);

        if(c2>max)
            max=c2;


        return max;


    }
    public static int maxProfit(int[] prices) {

        return maxProfitUtils(prices,0);

    }
}
