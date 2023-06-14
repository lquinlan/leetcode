public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0;
        int Max = flips[0];
        for (int i = 0; i < flips.length; i++) {
            Max = Math.max(Max, flips[i]);
            if ((i + 1) >= Max) {
                // System.out.println(i);
                ++ans;
            }

        }
        return ans;

    }
}