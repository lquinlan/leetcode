import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {

    }
}

class Solution {
    // int[] visited = new int[21];
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();

    void dfs(int cur, int k, int n, int ind) {
        if ((n - ind + 1) < (k - cur)) {
            return;
        }
        if (cur == k) {
            List<Integer> t = new ArrayList<Integer>(tmp);
            list.add(t);
            return;
        }
        for (int i = ind; i <= n; ++i) {
            // if (visited[i] == 0) {
            tmp.add(i);
            // visited[i] = 1;
            dfs(cur + 1, k, n, i + 1);
            tmp.remove(tmp.size() - 1);
            // visited[i] = 0;

            // }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(0, k, n, 1);
        return list;

    }
}