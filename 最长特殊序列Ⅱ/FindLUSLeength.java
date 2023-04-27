public class FindLUSLeength {
    public static void main(String[] args) {

    }

}

class Solution {
    int check(String a, String b) {
        int l = 0;
        int r = 0;
        while (l < a.length() && r < b.length()) {
            if (a.charAt(l) == b.charAt(r)) {
                ++l;
                ++r;
            } else {
                ++r;
            }
        }
        if (l == a.length()) {
            return -1;
        } else {
            return a.length();
        }
    }

    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int tmpmax = strs[i].length();
            for (int j = 0; j < strs.length; j++) {
                // System.out.println("j==" + j);
                if (j == i) {
                    continue;
                }
                int tmp = check(strs[i], strs[j]);
                if (tmp == -1) {
                    tmpmax = -1;
                    break;
                }

            }
            // System.out.println("tmpmax=" + tmpmax);
            max = Math.max(max, tmpmax);

        }
        return max;
    }
}