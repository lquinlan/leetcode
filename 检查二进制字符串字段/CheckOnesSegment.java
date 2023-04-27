public class CheckOnesSegment {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkOnesSegment(String s) {
        int f = 0;
        int onessum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onessum = onessum + 1 + f;
                if (f == 0) {
                    f = -1;
                }
            } else {
                f = 0;
            }
        }
        if (onessum == 1) {
            return true;
        } else {
            return false;
        }

    }
}