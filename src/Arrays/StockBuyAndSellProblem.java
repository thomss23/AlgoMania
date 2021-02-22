package Arrays;

public class StockBuyAndSellProblem {

    public static void main(String[] args) {
        int[] a = {1,5,3,8,12};
        System.out.println(buyAndSell(a));
    }

    private static int buyAndSell(int[] price) {

        int profit = 0;
        for(int i=1;i<price.length;i++) {
            if(price[i] > price[i-1])
                profit = profit + (price[i]-price[i-1]);
        }
        return profit;
    }
}
