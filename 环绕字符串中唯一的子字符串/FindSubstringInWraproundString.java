public class FindSubstringInWraproundString {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int curmax = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                curmax++;
            } else {
                curmax = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(curmax, count[p.charAt(i) - 'a']);
        }
        int ans = 0;
        for (var i : count) {
            ans += i;

        }
        return ans;

    }
}