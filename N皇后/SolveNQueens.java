import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(5);

    }

}

class Solution {
    int[][] map;
    List<List<String>> answer = new ArrayList<List<String>>();
    int[] row;
    int[] col;
    int[] zhudui;
    int[] fudui;

    void dfs(int n, int curn) {
        if (curn == n) {
            save();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (map[curn][i] == 0 && check(curn, i)) {
                map[curn][i] = 1;
                row[curn] = 1;
                col[i] = 1;
                int zhu = curn - i < 0 ? curn - i + zhudui.length : curn - i;
                zhudui[zhu] = 1;
                fudui[curn + i] = 1;
                dfs(n, curn + 1);
                map[curn][i] = 0;
                row[curn] = 0;
                col[i] = 0;
                // int zhu = curn - i < 0 ? curn - i + zhudui.length : curn - i;
                zhudui[zhu] = 0;
                fudui[curn + i] = 0;

            }

        }
    }

    boolean check(int i, int j) {
        int zhu = i - j < 0 ? i - j + zhudui.length : i - j;
        if (row[i] == 1 || col[j] == 1 || zhudui[zhu] == 1 || fudui[i + j] == 1) {
            return false;
        }
        return true;

    }

    void save() {
        List<String> tmp = new ArrayList<String>();

        for (int i = 0; i < map.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            tmp.add(sb.toString());

        }
        answer.add(tmp);
    }

    public List<List<String>> solveNQueens(int n) {
        map = new int[n][n];
        row = new int[2 * n - 1];
        col = new int[2 * n - 1];
        zhudui = new int[2 * n - 1];
        fudui = new int[2 * n - 1];
        dfs(n, 0);
        System.out.println(answer.toString());

        return answer;

    }
}