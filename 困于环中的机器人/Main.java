public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int[][] next = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

    public int nextInd(char t, int curind) {
        if (t == 'L') {
            return (curind + 1) % 4;
        } else {
            return (curind - 1 + 4) % 4;
        }

    }

    public boolean isRobotBounded(String instructions) {
        int l = 0, r = 0;
        int curind = 0;
        for (int i = 0; i < instructions.length(); ++i) {
            if (instructions.charAt(i) == 'L' || instructions.charAt(i) == 'R') {
                curind = nextInd(instructions.charAt(i), curind);
            } else {
                l += next[curind][0];
                r += next[curind][1];

            }

        }
        if ((l != 0 || r != 0) && curind == 0) {
            return false;
        } else {
            return true;
        }

    }
}