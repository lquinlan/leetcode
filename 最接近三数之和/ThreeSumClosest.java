import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] { 1, 2, 5, 10, 11 };
        solution.threeSumClosest(a, 12);

    }
}

class Solution {
    public int binarySearch1(int[] array, int left, int right, int target) {
        // int[] array = { 0, 1, 2, 3, 4, 5, 6 };
        // int target = 3;
        // int left = 0, right = array.length - 1;
        if (left > right) {
            return 99999;

        }
        if (left == right) {
            if (array[left] >= target) {
                return array[left];
            } else {
                return 99999;
            }
        }
        int l = left;
        int r = right;
        while (left <= right) {
            // 只修改了判断的条件，相当于将小于等于归为一类。
            int mid = (left + right) >> 1;
            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (left >= l && left <= r) {
            return array[left];
        } else {
            return 99999;
        }
        // return left;
    }

    public int binarySearch2(int[] array, int left, int right, int target) {
        // int[] array = { 0, 1, 2, 3, 4, 5, 6 };
        // int target = 3;
        // int left = 0, right = array.length - 1;
        if (left > right) {
            return 99999;

        }
        if (left == right) {
            if (array[left] <= target) {
                return array[left];
            } else {
                return 99999;
            }
        }
        int l = left;
        ;
        int r = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 只修改了判断的条件，相当于将大于等于归为一类。
            if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (right >= l && right <= r) {
            return array[right];
        } else {
            return 99999;
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 999999;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int s1 = target - sum;
                // int s2 = -s1;
                System.out.println("nums[i] = " + nums[i]);
                System.out.println("nums[j] = " + nums[j]);
                System.out.println("s1==" + s1);
                int k1 = binarySearch1(nums, j + 1, nums.length - 1, s1);
                int k2 = binarySearch2(nums, j + 1, nums.length - 1, s1);
                // int k3 = binarySearch1(nums, s2);
                // int k4 = binarySearch2(nums, s2);
                System.out.println("k1==" + k1);
                System.out.println("k2==" + k2);
                var tmp1 = Math.abs(target - sum - k1);
                var tmp2 = Math.abs(target - sum - k2);
                if (tmp1 <= tmp2) {
                    sum = sum + k1;
                } else {
                    sum = sum + k2;
                }
                tmp1 = Math.abs(target - ans);
                tmp2 = Math.abs(target - sum);
                if (tmp2 < tmp1) {
                    ans = sum;
                }
                System.out.println("ans==" + ans);

            }
        }
        return ans;

    }
}