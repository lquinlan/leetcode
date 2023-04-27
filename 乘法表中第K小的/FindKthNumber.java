public class FindKthNumber {
    public static void main(String[] args) {

    }
}

class Solution {
    int get(int m, int n, int nums) {
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            int tmp = Math.min(nums / i, n);
            ans += tmp;
            if (tmp == 0)
                break;

        }
        return ans;

    }

    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            int tmp = get(m, n, mid);
            if (tmp < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return l;

    }
}