public class StoneGameII {
    public static void main(String[] args) {

    }

}

class Solution {
    private int[][] mem = new int[101][101];
    private int[] sum;
    private int len;

    int dfs(int id, int m) {
        if (id == len) {
            return 0;
        }
        if (mem[id][m] != 0) {
            return mem[id][m];
        }
        int res = Integer.MIN_VALUE;
        for (int i = id; i < len; i++) {
            if ((i - id + 1) <= 2 * m) {
                res = Math.max(res, sum[i + 1] - sum[id] - dfs(i + 1, Math.max(m, i - id + 1)));

            }
        }
        mem[id][m] = res;
        return res;
    }

    public int stoneGameII(int[] piles) {
        len = piles.length;
        sum = new int[len + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = piles[i - 1] + sum[i - 1];
        }
        int cha = dfs(0, 1);
        // System.out.println(cha);
        return (sum[len] - cha) / 2 + cha;

    }
}