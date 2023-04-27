public class IsPalindrome {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9 && x >= 0) {
            return true;
        }
        int xt = 0;
        int tmp = x;
        while (tmp != 0) {
            xt = xt * 10 + tmp % 10;
            tmp /= 10;
        }
        return xt == x;

    }
}