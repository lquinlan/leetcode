public class Seven {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(8));

    }
}

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean f = false;
        if (num < 0) {
            // sb.append('-');
            f = true;
            num = -num;
        }
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        if (f) {
            sb.insert(0, '-');
        }

        return sb.toString();

    }
}