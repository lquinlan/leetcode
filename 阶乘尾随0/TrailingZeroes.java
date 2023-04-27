public class TrailingZeroes {
    public static void main(String[] args) {
        Solution res = new Solution();
        System.out.println(res.trailingZeroes(225));

    }
}

// 数据漏洞
class Solution1 {
    public int trailingZeroes(int n) {
        int count = 0;
        long res = 1;
        for (int i = 1; i <= n; ++i) {
            res = res * i;
            if (res % 10 == 0) {
                while (res % 10 == 0 && res > 0) {
                    ++count;
                    res /= 10;
                }
            } else {
                res %= 100000;
            }

        }
        // System.out.println(res);
        // System.out.println(count);
        while (res % 10 == 0 && res > 0) {
            ++count;
            res /= 10;
        }
        return count;

    }
}

//
// 正经做法
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = n; i / 5 > 0; i = i / 5) {
            count += i / 5;
        }
        return count;

    }
}