public class Reverse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(-1563847412);

    }
}

class Solution {
    String up = "2147483647";
    String down = "-2147483648";

    boolean comup(String nums) {
        if (nums.equals(up)) {
            return true;
        }
        if (nums.length() > up.length()) {
            return false;
        }
        if (nums.length() < up.length()) {
            return true;
        } else {
            for (int i = 0; i < up.length(); i++) {
                if (up.charAt(i) > nums.charAt(i)) {
                    return true;

                } else if (up.charAt(i) < nums.charAt(i)) {
                    return false;

                }

            }
            return false;
        }

    }

    boolean comdown(String nums) {
        if (nums.equals(down)) {
            return true;
        }
        if (nums.length() > down.length()) {
            return false;
        }
        if (nums.length() < down.length()) {
            return true;
        } else {
            for (int i = 0; i < down.length(); i++) {
                if (down.charAt(i) > nums.charAt(i)) {
                    return true;

                } else if (down.charAt(i) < nums.charAt(i)) {
                    return false;

                }

            }
            return false;
        }

    }

    public int reverse(int x) {
        System.out.println("x==" + x);
        if (x == 0) {
            return 0;
        }
        if (x == 2147483647 || x == -2147483648) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append('-');
            x = -x;
        }
        System.out.println("x==" + x);
        int z0 = 1;
        while (x != 0) {
            int tmp = (x % 10);
            // System.out.println("tmp=="+tmp);
            if (tmp == 0 && z0 == 1) {
                x /= 10;
                continue;
            } else {
                z0 = 0;
                sb.append("" + tmp);
                x /= 10;
            }

        }
        System.out.println(sb.toString());
        boolean f = false;
        if (sb.charAt(0) == '-') {
            f = comdown(sb.toString());

        } else {
            f = comup(sb.toString());
        }
        System.out.println("f==" + f);

        if (f == false) {
            return 0;
        } else {
            int ind = 0;
            int ff = 1;
            if (sb.charAt(0) == '-') {
                ++ind;
                ff = -ff;

            }
            int ans = 0;
            for (; ind < sb.length(); ind++) {
                ans = ans * 10 + (sb.charAt(ind) - '0');

            }
            return ans * ff;
        }

    }
}