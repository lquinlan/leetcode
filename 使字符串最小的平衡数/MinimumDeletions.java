public class MinimumDeletions {
    public static void main(String[] args) {

    }
}

// class Solution {
// public int minimumDeletions(String s) {
// int len = s.length();
// int[] pre = new int[len];
// int[] last = new int[len];
// int cnt = Integer.MAX_VALUE;
// pre[0] = 0;
// last[len - 1] = 0;
// if (s.charAt(0) == 'a') {
// pre[0] = 1;
// }
// if (s.charAt(len - 1) == 'b') {
// last[len - 1] = 1;
// }
// for (int i = 1; i < len; i++) {
// if (s.charAt(i) == 'a') {
// pre[i] = pre[i - 1] + 1;

// } else {
// pre[i] = pre[i - 1];
// }
// if (s.charAt(len - 1 - i) == 'b') {
// last[len - i - 1] = last[len - i] + 1;
// } else {
// last[len - i - 1] = last[len - i];

// }

// }
// for (int i = 0; i < len; i++) {
// int tmp = (i + 1) - pre[i] + (len - i - 1 - last[i]);
// cnt = Math.min(cnt, tmp);

// }
// return cnt;
// }
// }

// aababbab

class Solution {
    public int minimumDeletions(String s) {
        int cura = 0;
        int curb = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'b') {
                ++curb;
            } else {
                cura = Math.min(cura + 1, curb);
            }
        }
        return cura;
    }
}