import java.util.ArrayList;
import java.util.List;

public class MaximalNetworkRank {
    public static void main(String[] args) {

    }

}

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] dp = new int[n];
        int[] vis = new int[n];
        List<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 00; i < n; ++i) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; ++i) {
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);
            dp[roads[i][0]]++;
            dp[roads[i][1]]++;

        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int tmpans = dp[i];
            vis[i] = 1;
            for (int j = 0; j < map.get(i).size(); ++j) {
                int node = map.get(i).get(j);
                vis[node] = 1;
                if (node <= i) {
                    continue;
                }
                ans = Math.max(ans, tmpans + dp[node] - 1);
            }
            for (int k = 0; k < n; ++k) {
                if (vis[k] == 1) {
                    vis[k] = 0;
                    continue;
                } else {
                    ans = Math.max(ans, tmpans + dp[k]);
                }
            }

        }
        return ans;

    }
}