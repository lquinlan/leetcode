public class MaxSub {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("b"));

    }
}
// 纯暴力O(n^3)
// class Solution {
// boolean check(String sub) {
// // int mid = sub.length() / 2;
// int i = 0;
// int j = sub.length() - 1;
// while (i < j) {
// if (sub.charAt(i) != sub.charAt(j)) {
// return false;
// }
// ++i;
// --j;
// }
// return true;
// }

// public String longestPalindrome(String s) {
// int max_i = 0;
// int max_j = 0;
// int max = 0;
// for (int i = 0; i < s.length(); ++i) {
// for (int j = i; j < s.length(); ++j) {
// if (check(s.substring(i, j + 1))) {
// if (max < (j - i + 1)) {
// max = (j - i + 1);
// max_i = i;
// max_j = j + 1;
// }

// }
// }
// }
// return s.substring(max_i, max_j);

// }
// }

class Solution {

    int checkMax(String s, int mid) {
        int i = mid;
        int j = mid;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            --i;
            ++j;
        }
        // abbbb
        return j - mid;

    }

    int checkMax(String s, int mid1, int mid2) {
        int i = mid1;
        int j = mid2;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            --i;
            ++j;
        }
        // da a a ac
        return j - mid2;
    }

    public String longestPalindrome(String s) {
        int s1 = 0;
        int s2 = 0;
        int max_i = 0;
        int max_j = 0;

        for (int i = 0; i < s.length(); ++i) {
            s1 = checkMax(s, i);
            System.out.println("s1=" + s1);

            s2 = checkMax(s, i, i + 1);
            System.out.println("s2=" + s2);
            int s1i = i - s1 + 1;
            int s1j = s1 + i;
            int s2i = i - s2 + 1;
            int s2j = i + 1 + s2;
            if ((s1j - s1i) > (max_j - max_i)) {
                max_i = s1i;
                max_j = s1j;
            }
            if ((s2j - s2i) > (max_j - max_i)) {
                max_i = s2i;
                max_j = s2j;
            }
            System.out.println("max_i=" + max_i);
            System.out.println("max_j" + max_j);

        }
        return s.substring(max_i, max_j);
    }
}