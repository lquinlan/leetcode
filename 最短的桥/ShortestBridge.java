import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1 }, { 1, 0 } };
        Solution solution = new Solution();
        solution.shortestBridge(grid);

    }

}

class Solution {
    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j >= grid[i].length || j < 0) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        } else {
            return;
        }

    }

    class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int[][] vis = new int[105][105];

    public int shortestBridge(int[][] grid) {
        boolean f = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    f = true;
                    break;
                }
            }
            if (f) {
                break;
            }

        }

        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == -1) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int h = grid.length;
        int w = grid[0].length;
        int ans = 0;
        while (!queue.isEmpty()) {
            int s = queue.size();
            ++ans;
            for (int c = 0; c < s; c++) {
                Pair tmp = queue.poll();
                vis[tmp.i][tmp.j] = 1;

                if (tmp.i + 1 < h) {
                    if (grid[tmp.i + 1][tmp.j] == 0 && vis[tmp.i + 1][tmp.j] == 0) {
                        queue.add(new Pair(tmp.i + 1, tmp.j));
                        vis[tmp.i + 1][tmp.j] = 1;
                    } else if (grid[tmp.i + 1][tmp.j] == 1) {
                        return ans - 1;

                    }
                }
                if (tmp.j + 1 < w) {
                    if (grid[tmp.i][tmp.j + 1] == 0 && vis[tmp.i][tmp.j + 1] == 0) {
                        queue.add(new Pair(tmp.i, tmp.j + 1));
                        vis[tmp.i][tmp.j + 1] = 1;
                    } else if (grid[tmp.i][tmp.j + 1] == 1) {
                        return ans - 1;

                    }
                }
                if (tmp.i - 1 >= 0) {
                    if (grid[tmp.i - 1][tmp.j] == 0 && vis[tmp.i - 1][tmp.j] == 0) {
                        queue.add(new Pair(tmp.i - 1, tmp.j));
                        vis[tmp.i - 1][tmp.j] = 1;
                    } else if (grid[tmp.i - 1][tmp.j] == 1) {
                        return ans - 1;

                    }
                }
                if (tmp.j - 1 >= 0) {
                    if (grid[tmp.i][tmp.j - 1] == 0 && vis[tmp.i][tmp.j - 1] == 0) {
                        queue.add(new Pair(tmp.i, tmp.j - 1));
                        vis[tmp.i][tmp.j - 1] = 1;
                    } else if (grid[tmp.i][tmp.j - 1] == 1) {
                        return ans - 1;

                    }
                }

            }
        }

        return ans - 1;

    }
}