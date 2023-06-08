public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.tilingRectangle(5, 6);

    }
}

class Solution {
    int ans = Integer.MAX_VALUE;
    boolean[][] vis;

    public int tilingRectangle(int n, int m) {
        vis = new boolean[n][m];
        dfs(0, 0, n, m, 0);
        return ans;
    }

    void print() {
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                System.out.print(vis[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void dfs(int x, int y, int n, int m, int tmpans) {
        print();
        if (tmpans >= ans) {
            return;
        }
        if (x >= n) {
            ans = Math.min(tmpans, ans);
            return;
        }
        if (y >= m) {
            dfs(x + 1, 0, n, m, tmpans);
            return;
        }
        if (vis[x][y]) {
            dfs(x, y + 1, n, m, tmpans);
        }

        for (int k = Math.min(n, m); k >= 0; --k) {
            if (x + k < n && y + k < m && check(x, y, k)) {
                full(x, y, k, true);
                dfs(x, y + k+1 , n, m, tmpans + 1);
                full(x, y, k, false);
            }
        }
    }

    

    boolean check(int x, int y, int k) {
        for (int i = 0; i <= k; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (vis[x + i][y + j] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    void full(int x, int y, int k, boolean f) {
        for (int i = 0; i <= k; ++i) {
            for (int j = 0; j <= k; ++j) {
                vis[x + i][y + j] = f;
            }
        }

    }
}