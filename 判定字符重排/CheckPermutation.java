public class CheckPermutation {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        long ans1 = 17;
        long ans2 = 17;
        for (int i = 0; i < s1.length(); ++i) {
            ans1 = ans1 + ((int) s1.charAt(i)) * (17 * (int) s1.charAt(i) % 2);
            ans2 = ans2 + ((int) s2.charAt(i)) * (17 * (int) s2.charAt(i) % 2);
        }
        if (ans1 == ans2) {
            return true;
        } else {
            return false;
        }

    }
}