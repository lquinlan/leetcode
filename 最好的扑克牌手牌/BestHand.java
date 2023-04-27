
import java.util.Arrays;

public class BestHand {
    public static void main(String[] args) {

    }
}

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if (isFlush(suits)) {
            return "Flush";
        }
        int cnt = count(ranks);
        if (cnt >= 3) {
            return "Three of a Kind";

        } else if (cnt == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }

    boolean isFlush(char[] suits) {
        char a = suits[0];
        for (int i = 1; i < suits.length; i++) {
            if (a != suits[i]) {
                return false;
            }

        }
        return true;
    }

    int count(int[] ranks) {
        Arrays.sort(ranks);
        int cnt = 1;
        int ans = 0;
        int s = ranks[0];
        for (int i = 1; i < 5; ++i) {
            if (s == ranks[i]) {
                ++cnt;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
                s = ranks[i];
            }
        }
        ans = Math.max(ans, cnt);
        return ans;

    }
}