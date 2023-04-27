public class RotateString {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int ind = -1;
        while (true) {
            ind = goal.indexOf(s.charAt(0), ind + 1);
            if (ind == -1) {
                return false;
            }
            int i = 0;
            for (i = 0; i < goal.length(); i++) {
                if (goal.charAt((i + ind) % goal.length()) != s.charAt(i)) {
                    break;
                }
            }
            if (i == goal.length()) {
                return true;
            }

        }
        // return false;

    }
}