public class LongestCommonPrefix {
    public static void main(String[] args) {

    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String tmp = strs[0];
        int len = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            int t = 0;
            while (tmp.charAt(t) == strs[i].charAt(t))
                t++;
            len = Math.min(len, t);

        }
        return tmp.substring(0, len);

    }
}