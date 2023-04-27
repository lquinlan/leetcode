public class MaxProfit {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int cntProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                cntProfit += (prices[i + 1] - prices[i]);
            }

        }
        return cntProfit;

    }
}