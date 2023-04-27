public class MagicalString {
    public static void main(String[] args) {

    }
}

class Solution {
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] str = new char[n];
        str[0] = '1';
        str[1] = '2';
        str[2] = '2';
        int i = 2;
        int j = 3;
        int ans = 1;
        while (j < n) {
            int len = str[i] - '0';
            int nums = 3 - (str[j - 1] - '0');
            while (len > 0 && j < n) {
                str[j] = (char) ('0' + nums);
                if (nums == 1) {
                    ans++;
                }
                ++j;
                --len;
            }
            ++i;
        }
        return ans;
    }
}
