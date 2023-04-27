public class UniquePathsWithObstacles {
    public static void main(String[] args) {

    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] answer = new int[obstacleGrid.length][obstacleGrid[0].length];
        answer[0][0] = 1;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if ((i == 0 && j == 0) || (obstacleGrid[i][j] == 1)) {
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
        return answer[answer.length - 1][answer[0].length - 1];

    }
}