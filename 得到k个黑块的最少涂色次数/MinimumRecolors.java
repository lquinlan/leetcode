public class MinimumRecolors {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = 200;
        int tmpw = 0;
        for (int i = 0; i < blocks.length(); ++i) {
            if (i < k && blocks.charAt(i) == 'W') {
                ++tmpw;

            } else {
                ans = Math.min(ans, tmpw);
                if (blocks.charAt(i - k) == 'W') {
                    --tmpw;
                }
                if (blocks.charAt(i) == "W") {
                    ++tmpw;
                }
            }

        }
        return ans;

    }
}