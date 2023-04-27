import java.util.Arrays;

public class MovesToMakeZigzag {
    public static void main(String[] args) {

    }

}

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        int[] tmp = new int[nums.length];
        int[] tmp2 = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        System.arraycopy(nums, 0, tmp2, 0, nums.length);
        // System.out.println(tmp[3]);
        for (int i = 0; i < tmp.length - 1; i++) {
            if (i % 2 == 0) {
                if (tmp[i + 1] >= tmp[i]) {
                    cnt1 += (tmp[i + 1] - tmp[i] + 1);
                    tmp[i + 1] = tmp[i] - 1;
                }

            } else {
                if (tmp[i + 1] <= tmp[i]) {
                    cnt1 += (tmp[i] - tmp[i + 1] + 1);
                    tmp[i + 1] = tmp[i] + 1;
                }

            }

        }
        System.out.println(cnt1);
        for (int i = 0; i < tmp2.length - 1; i++) {
            if (i % 2 != 0) {
                if (tmp2[i + 1] <= tmp2[i]) {
                    cnt2 += (tmp2[i] - tmp2[i + 1] + 1);
                    tmp2[i + 1] = tmp2[i] + 1;
                }

            } else {
                if (tmp2[i + 1] >= tmp2[i]) {
                    cnt2 += (tmp2[i + 1] - tmp2[i] + 1);
                    tmp2[i + 1] = tmp2[i] - 1;
                }
            }

        }
        System.out.println(cnt2);
        if (cnt1 == 0) {
            cnt1 = (1 << 30);
        }
        if (cnt2 == 0) {
            cnt2 = (1 << 30);
        }

        return Math.min(cnt1, cnt2);

    }
}