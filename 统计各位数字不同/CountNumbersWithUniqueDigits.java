public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int answer = 10;
        for (int j = 2; j <= n; ++j) {
            int tmp = 9;
            for (int i = 0; i < (j - 1); i++) {
                tmp = tmp * (9 - i);

            }
            answer = answer + tmp;

        }

        return answer;

    }
}