public class BestCoordinate {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int n = Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            n = Math.max(n, tower[0]);
            m = Math.max(m, tower[1]);
        }
        double maxpower = 0;
        int[] ans = { -1, -1 };
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                double power = 0;
                for (int[] tower : towers) {
                    int dst = (tower[0] - i) * (tower[0] - i) + (tower[1] - j) * (tower[1] - j);
                    if (dst <= radius * radius) {
                        power += Math.floor(tower[2] / (1 + Math.sqrt((double) dst)));

                    }

                }
                if (power > maxpower) {
                    maxpower = power;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;

    }
}