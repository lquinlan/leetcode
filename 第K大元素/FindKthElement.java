public class FindKthElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] { 3, 2, 1, 5, 6, 4 };
        System.out.println(solution.findKthLargest(a, 2));

    }
}

class Solution {
    int quickSort(int[] nums, int s, int e, int k) {

        int ind = (int) (Math.random() * (e - s) + s);

        int f = nums[ind];

        nums[ind] = nums[s];
        nums[s] = f;
        int l = s;
        int r = e - 1;
        while (l < r) {
            while (l < r && nums[r] >= f) {
                --r;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= f) {
                ++l;
            }
            nums[r] = nums[l];

        }
        nums[l] = f;
        // System.out.println("l==" + l);
        // System.out.println("r==" + r);
        // for (var i : nums) {
        // System.out.println(i);
        // }
        // nums[ind] = nums[l];
        // nums[l] = f;
        if (l == k) {
            return nums[l];
        } else if (l < k) {
            return quickSort(nums, l + 1, e, k);
        } else {
            return quickSort(nums, s, l, k);
        }

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length, nums.length - k);

    }
}