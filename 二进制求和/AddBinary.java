public class AddBinary {
    public static void main(String[] args) {

    }
}

class Solution {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String tmp = b;
            b = a;
            a = tmp;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int f = 0;
        while (j >= 0) {
            int tmp = a.charAt(i) - '0' + b.charAt(j) - '0' + f;
            if (tmp >= 2) {
                sb.append(tmp % 2 + '0');
                f = 1;
            } else {
                f = 0;
                sb.append(tmp + '0');
            }
            --i;
            --j;

        }
        while (i >= 0) {
            int tmp = a.charAt(i) - '0' + f;
            if (tmp >= 2) {
                sb.append(tmp % 2 + '0');
                f = 1;
            } else {
                f = 0;
                sb.append(tmp + '0');
            }
            --i;
        }
        sb.reverse();
        return sb.toString();

    }
}