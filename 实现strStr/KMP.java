public class KMP {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] next;

    void getNext(String txt, String mo) {
        // int n = txt.length();
        int m = mo.length();
        next = new int[m];
        next[0] = 0;
        for (int i = 1, j = 0; i < m; ++i) {
            while (j > 0 && mo.charAt(i) != mo.charAt(j)) {
                j = next[j - 1];

            }
            if (mo.charAt(j) == mo.charAt(i)) {
                ++j;
            }
            next[i] = j;
        }

    }

    int indexOf(String txt, String mo) {
        int n = txt.length();
        int m = mo.length();
        for (int i = 0, j = 0; i < n; ++i) {
            while (j > 0 && txt.charAt(i) != mo.charAt(j)) {
                j = next[j - 1];

            }
            if (mo.charAt(j) == txt.charAt(i)) {
                ++j;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;

    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        getNext(haystack, needle);
        return indexOf(haystack, needle);

    }
}