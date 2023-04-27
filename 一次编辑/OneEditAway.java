public class OneEditAway {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) >= 2) {
            return false;
        }
        if (first.equals(second)) {
            return true;
        }
        if (first.length() < second.length()) {
            String tmp = second;
            second = first;
            first = tmp;
        }
        if (first.length() == second.length()) {
            int cnt = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    ++cnt;
                }
            }
            if (cnt == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            int first_l = 0;
            int second_l = 0;
            while (first_l < first.length() && second_l < second.length()) {
                if (first.charAt(first_l) == second.charAt(second_l)) {
                    ++first_l;
                    ++second_l;
                } else {
                    ++first_l;
                }
            }
            if (second_l == second.length()) {
                return true;
            } else {
                return false;
            }
        }

    }
}