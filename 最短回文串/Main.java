// import java.util.Arrays;

public class Main {

}

class Solution {
    public String shortestPalindrome(String s) {
        return longestPalindrome(s);

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] t = preprocess(s);
        // System.out.println(Arrays.toString(t));
        int n = t.length;
        int[] p = new int[n];

        int center = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            if (right > i) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }
            while (t[i + p[i] + 1] == t[i - p[i] - 1]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            // if (p[i] > maxLen) {
            // maxLen = p[i];
            // maxIndex = i;
            // }
        }
        // // System.out.println(Arrays.toString(p));
        // int start = (maxIndex - maxLen - 1) / 2;
        // int end = start + maxLen;
        int maxs = 0;
        int maxlen = 0;
        for (int i = 2; i < p.length - 1; ++i) {
            if (s.charAt(i / 2 - 1) >= 'a' && s.charAt(i / 2 - 1) <= 'z') {
                int st = (i - p[i] - 1) / 2;
                if (st == 0 && p[i] > maxlen) {
                    maxlen = p[i];
                    maxs = st + p[i];
                }
            }

        }
        StringBuilder prefix = new StringBuilder(s.substring(maxs));
        return prefix.reverse().append(s).toString();
        // return maxLen==s.length();
    }

    private static char[] preprocess(String s) {
        int n = s.length();
        char[] t = new char[n * 2 + 3];
        t[0] = '$';
        t[n * 2 + 2] = '#';
        for (int i = 0; i < n; i++) {
            t[i * 2 + 1] = '#';
            t[i * 2 + 2] = s.charAt(i);
        }
        t[n * 2 + 1] = '#';
        return t;
    }
}