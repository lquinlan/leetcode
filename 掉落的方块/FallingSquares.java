import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FallingSquares {
    public static void main(String[] args) {

    }
}

class Solution {
    // class node {
    // int ind;
    // int x;
    // int y;
    // int l;

    // node(int ind, int x, int y, int l) {
    // this.ind = ind;
    // this.x = x;
    // this.y = y;
    // this.l = l;

    // }
    // }

    public List<Integer> fallingSquares(int[][] positions) {
        int[] he = new int[positions.length];
        int[] re = new int[positions.length];
        // List<node> nodes = new ArrayList<node>();
        int curmax = -1;
        for (int i = 0; i < positions.length; i++) {
            if (i == 0) {
                he[i] = positions[i][1];
                re[i] = positions[i][1];
                curmax = he[i];

            } else {
                int tmpmax = -1;
                for (int j = 0; j < i; j++) {
                    if ((positions[i][0] < positions[j][0] + positions[j][1] && positions[i][0] >= positions[j][0])
                            || (positions[i][0] + positions[i][1] <= positions[j][0] + positions[j][1]
                                    && positions[i][0] + positions[i][1] > positions[j][0])
                            || (positions[i][0] <= positions[j][0]
                                    && positions[i][0] + positions[i][1] >= positions[j][0] + positions[j][1])) {
                        tmpmax = Math.max(re[j] + positions[i][1], tmpmax);

                    }

                }
                tmpmax = Math.max(tmpmax, positions[i][1]);
                re[i] = tmpmax;
                curmax = Math.max(tmpmax, curmax);
                he[i] = curmax;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (var i : he) {
            result.add(i);
        }
        return result;

    }
}