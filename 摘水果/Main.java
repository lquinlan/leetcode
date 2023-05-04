
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxlen = fruits[fruits.length - 1][0];
        int[] presum = new int[maxlen + 3];
        int last = 0;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = last; j <= fruits[i][0]; j++) {
                if (j != fruits[i][0]) {
                    presum[j + 1] = presum[j];
                } else {
                    presum[j + 1] = presum[j] + fruits[i][1];
                }
            }
            last = fruits[i][0] + 1;
        }
        for (int j = last; j < presum.length - 1; j++) {
            presum[j + 1] = presum[j];

        }

        int ansMax = Integer.MIN_VALUE;
        if (startPos > maxlen) {

            k -= (startPos - maxlen);
            startPos = maxlen;
        }
        if (k < 0) {
            return 0;
        }
        for (int i = 0; i <= k / 2; ++i) {
            int j = k - 2 * i;
            int tmpansl = 0;
            int tmpansr = 0;

            if (startPos - i >= 0) {
                tmpansl += presum[startPos + 1] - presum[startPos - i];
            } else {
                tmpansl += presum[startPos + 1] - presum[0];
            }
            if (startPos + j + 1 < presum.length) {
                tmpansl += presum[startPos + j + 1] - presum[startPos + 1];
            } else {
                tmpansl += presum[presum.length - 1] - presum[startPos + 1];
            }

            if (startPos - j >= 0) {
                tmpansr += presum[startPos + 1] - presum[startPos - j];
            } else {
                tmpansr += presum[startPos + 1] - presum[0];
            }
            if (startPos + i + 1 < presum.length) {
                tmpansr += presum[startPos + i + 1] - presum[startPos + 1];
            } else {
                tmpansr += presum[presum.length - 1] - presum[startPos + 1];
            }
            ansMax = Math.max(ansMax, Math.max(tmpansl, tmpansr));

        }
        return ansMax;

    }
}