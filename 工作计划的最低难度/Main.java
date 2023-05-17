// import java.lang.reflect.Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int[][] tmpans;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        tmpans = new int[jobDifficulty.length + 5][d + 5];
        for (int i = 0; i < tmpans.length; ++i) {
            Arrays.fill(tmpans[i],-1);
        }
        return dfs(jobDifficulty, d, 0, 1);

    }

    int dfs(int[] jobDifficulty, int d, int ind, int curd) {
        if (tmpans[ind][curd] != -1) {
            return tmpans[ind][curd];
        }
        if (curd > d && ind >= jobDifficulty.length) {
            return 0;
        } else if (curd > d && ind < jobDifficulty.length) {
            return 100005;
        }
        int ansMin = Integer.MAX_VALUE;
        int tmpmax = 0;
        for (int i = ind; i < jobDifficulty.length - (d - curd); ++i) {
            tmpmax = Math.max(tmpmax, jobDifficulty[i]);
            ansMin = Math.min(ansMin, tmpmax + dfs(jobDifficulty, d, i + 1, curd + 1));

        }
        tmpans[ind][curd] = ansMin;
        return ansMin;
    }
}