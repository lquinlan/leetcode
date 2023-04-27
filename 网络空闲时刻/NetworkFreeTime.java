import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NetworkFreeTime {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Solution {
    void bfs(List<List<Integer>> map, int[] dist) {
        Deque<Integer> d = new ArrayDeque<Integer>();
        d.add(0);
        int depth = 0;
        while (!d.isEmpty()) {
            // int tmp = d.poll();
            ++depth;
            int size = d.size();
            for (int j = 0; j < size; j++) {
                int tmp = d.poll();
                for (var i : map.get(tmp)) {
                    if (dist[i] == 0) {
                        dist[i] = depth;
                        d.add(i);
                    }

                }

            }

        }

    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<List<Integer>> map = new ArrayList<List<Integer>>(patience.length);
        int[] dist = new int[patience.length];
        dist[0] = 1;
        for (int i = 0; i < dist.length; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            map.add(tmp);
        }
        int ans = 0;
        for (int i = 0; i < edges.length; ++i) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        bfs(map, dist);
        int curans = 0;
        for (int i = 1; i < dist.length; i++) {
            curans = 2 * dist[i] + 1 + ((2 * dist[i] - 1) / patience[i]) * patience[i];
            ans = curans > ans ? curans : ans;
        }

        return ans;

    }
}