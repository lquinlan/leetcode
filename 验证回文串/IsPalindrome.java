public class IsPalindrome {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
        s.toLowerCase();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                tmp.append(s.charAt(i));
            }
        }
        int len = tmp.length();
        int l = 0, r = len - 1;
        while (l < r) {
            if (tmp.charAt(l) != tmp.charAt(r)) {
                return false;
            }
        }
        return true;

    }
}