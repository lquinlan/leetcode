public class Multiply {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.multiply("9", "99");

    }
}

class Solution {
    StringBuilder mul(String num1, char num2) {
        int n2 = num2 - '0';
        int f = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int tmp = n1 * n2 + f;
            if (tmp > 9) {
                char tmp2 = (char) (tmp % 10 + '0');
                sb.append(tmp2);
                // tmp2 = (char) (tmp / 10 + '0');
                // sb.append(tmp2);
                f = tmp / 10;
            } else {
                char tmp2 = (char) (tmp + '0');
                sb.append(tmp2);
                f = 0;

            }

        }
        if (f != 0) {
            char tmp2 = (char) (f + '0');
            sb.append(tmp2);

        }

        sb.reverse();

        return sb;
    }

    StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int f = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1, j = len2 - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            // /System.out.println()
            int tmpadd = n1 + n2 + f;
            if (tmpadd >= 10) {
                f = 1;
                char tmp2 = (char) (tmpadd % 10 + '0');
                sb.append(tmp2);
            } else {
                f = 0;
                char tmp2 = (char) (tmpadd + '0');
                sb.append(tmp2);
            }
        }
        // System.out.println(sb.toString());
        while (i >= 0) {
            int n1 = num1.charAt(i) - '0';
            int tmpadd = n1 + f;
            if (tmpadd >= 10) {
                f = 1;
                char tmp2 = (char) (tmpadd % 10 + '0');
                sb.append(tmp2);
            } else {
                f = 0;
                char tmp2 = (char) (tmpadd + '0');
                sb.append(tmp2);
            }
            --i;

        }
        while (j >= 0) {
            int n1 = num2.charAt(j) - '0';
            int tmpadd = n1 + f;
            if (tmpadd >= 10) {
                f = 1;
                char tmp2 = (char) (tmpadd % 10 + '0');
                sb.append(tmp2);
            } else {
                f = 0;
                char tmp2 = (char) (tmpadd + '0');
                sb.append(tmp2);
            }
            --j;

        }
        if (f != 0) {
            char tmp2 = (char) (f + '0');
            sb.append(tmp2);

        }
        sb.reverse();

        return sb;

    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num2.length() > num1.length()) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        // int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder ans = new StringBuilder();
        ans.append('0');
        for (int i = len2 - 1; i >= 0; --i) {
            StringBuilder tmpmul = mul(num1, num2.charAt(i));
            System.out.println(tmpmul.toString());
            for (int j = 0; j < len2 - 1 - i; ++j) {
                tmpmul.append('0');

            }
            System.out.println(tmpmul.toString());
            ans = add(ans, tmpmul);

        }

        System.out.println("ans==" + ans.toString());

        return ans.toString();

    }
}