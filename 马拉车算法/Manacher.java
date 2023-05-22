import java.util.Arrays;

public class Manacher {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("A"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] t = preprocess(s);
        System.out.println(Arrays.toString(t));
        int n = t.length;
        int[] p = new int[n];
        
        int center = 0, right = 0, maxLen = 0, maxIndex = 0;
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
            if (p[i] > maxLen) {
                maxLen = p[i];
                maxIndex = i;
            }
        }
        System.out.println(Arrays.toString(p));
        int start = (maxIndex - maxLen - 1) / 2;
        int end = start + maxLen;
        return s.substring(start, end);
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
