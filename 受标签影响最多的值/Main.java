import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

// import java.util.Set;
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] pair = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            pair[i][0] = values[i];
            pair[i][1] = labels[i];
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int ans = 0;
        while (numWanted > 0 && i < pair.length) {
            if (map.getOrDefault(pair[i][1], 0) < useLimit) {
                // if(useLimit>1){
                ans += pair[i][0];
                --numWanted;
                // --useLimit;
                map.put(pair[i][1], map.getOrDefault(pair[i][1], 0) + 1);

            }
            ++i;
        }
        return ans;
    }
}