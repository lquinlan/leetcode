
public class Path {
    public static void main(String[] args) {
        Long s = System.currentTimeMillis();
        Solution solution = new Solution();
        int ans = solution.uniquePaths(3, 7);
        System.out.println(ans);
        Long e = System.currentTimeMillis();
        System.out.println(e - s);
    }
}
// dfs
// class Solution {
// int answer;
// int m;
// int n;

// private void setM(int m) {
// this.m = m;
// }

// private void setN(int n) {
// this.n = n;
// }

// Solution() {
// answer = 0;
// }

// void dfs(int x, int y) {
// if (x == this.m && y == this.n) {
// ++this.answer;
// }
// if (x > this.m) {
// return;
// }
// if (y > this.n) {
// return;
// }
// dfs(x + 1, y);
// dfs(x, y + 1);
// }

// public int uniquePaths(int m, int n) {
// setM(m);
// setN(n);
// dfs(1, 1);
// return answer;

// }
// }

// dp

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] answer = new int[m][n];
        answer[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i - 1 >= 0) {
                    answer[i][j] += answer[i - 1][j];
                }
                if (j - 1 >= 0) {
                    answer[i][j] += answer[i][j - 1];
                }
            }
        }
        return answer[m - 1][n - 1];
    }
}