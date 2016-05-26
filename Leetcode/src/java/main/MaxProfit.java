import java.util.Arrays;

/**
 * Created by look on 16/7/18.
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 0){
            int max = prices[prices.length -1];
            for (int i= prices.length -1; i>0; i--){
                if (prices[i] > max){
                    max = prices[i];
                }
                int profit = max - prices[i-1];
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1};
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(input);
        System.out.println(result);
    }


}
