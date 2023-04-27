import java.util.ArrayList;
import java.util.List;

public class CountIslandsNums {
    public static void main(String[] args) {
        char[][] map = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        Solution1 solution = new Solution1();
        System.out.println(solution.numIslands(map));

    }
}

// 深度优先搜索
class Solution1 {
    boolean[][] visited = new boolean[300][300];
    int ans = 0;

    boolean dfs(char[][] nums, int x, int y) {
        if (visited[x][y] || nums[x][y] == '0') {
            return false;
        }
        visited[x][y] = true;
        if (y - 1 >= 0 && nums[x][y - 1] == '1') {
            dfs(nums, x, y - 1);
        }
        if (x - 1 >= 0 && nums[x - 1][y] == '1') {
            dfs(nums, x - 1, y);
        }
        if (y + 1 < nums[0].length && nums[x][y + 1] == '1') {
            dfs(nums, x, y + 1);
        }
        if (x + 1 < nums.length && nums[x + 1][y] == '1') {
            dfs(nums, x + 1, y);
        }

        return true;

    }

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, i, j)) {
                    ++ans;
                }
            }
        }

        return ans;

    }
}

// 并查集
class Solution {
    List<Integer> parents = new ArrayList<Integer>();
    List<Integer> rank = new ArrayList<Integer>();
    int ans = 0;

    void init(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    parents.add(i * grid[0].length + j);
                    ++ans;
                } else {
                    parents.add(-1);
                }
                rank.add(0);
            }
        }

    }

    int find(int i) {

        if (parents.get(i) != i) {
            parents.set(i, find(parents.get(i)));
        }
        return parents.get(i);
    }

    void unit(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            if (rank.get(rx) < rank.get(ry)) {
                rx = rx ^ ry;
                ry = rx ^ ry;
                rx = rx ^ ry;
            }
            parents.set(ry, rx);
            if (rank.get(rx) == rank.get(ry)) {
                rank.set(rx, rank.get(rx) + 1);
            }
            --ans;
        }
    }

    public int numIslands(char[][] grid) {
        init(grid);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1')
                        unit(r * grid[0].length + c, (r - 1) * grid[0].length + c);
                    if (r + 1 < grid.length && grid[r + 1][c] == '1')
                        unit(r * grid[0].length + c, (r + 1) * grid[0].length + c);
                    if (c - 1 >= 0 && grid[r][c - 1] == '1')
                        unit(r * grid[0].length + c, r * grid[0].length + c - 1);
                    if (c + 1 < grid[0].length && grid[r][c + 1] == '1')
                        unit(r * grid[0].length + c, r * grid[0].length + c + 1);
                }
            }
        }

        return ans;

    }
}