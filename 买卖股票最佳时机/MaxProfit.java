public class MaxProfit {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int[] curmax = new int[prices.length];
        curmax[curmax.length - 1] = -1;
        for (int i = curmax.length - 2; i >= 0; --i) {
            curmax[i] = Math.max(prices[i + 1], curmax[i + 1]);
        }
        int maxans = 0;
        // int curans = 0;
        for (int i = 0; i < curmax.length; ++i) {
            if (curmax[i] - prices[i] > maxans) {
                maxans = curmax[i] - prices[i];
            }
        }
        return maxans;

    }
}