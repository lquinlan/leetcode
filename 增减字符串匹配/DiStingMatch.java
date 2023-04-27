public class DiStingMatch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.diStringMatch("IDID");

    }

}

class Solution {
    public int[] diStringMatch(String s) {
        int curMax = s.length();
        int curMin = 0;
        int last = -1;
        int[] ans = new int[curMax + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = curMin;
                ++curMin;
                last = curMax;
            } else {
                ans[i] = curMax;
                --curMax;
                last = curMin;
            }
        }
        ans[s.length() - 1] = last;
        return ans;

    }
}