
import java.util.*;

public class Add {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 2, 4 };
        int[] ans = solution.twoSum(nums, 6);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // ArrayList<Integer> index = new ArrayList<Integer>();
        int[] tnum = new int[nums.length];
        System.arraycopy(nums, 0, tnum, 0, nums.length);
        Arrays.sort(nums);
        int ans1 = 0;
        int ans2 = 0;
        int count = 0;
        for (int i : nums) {
            {
                if (i <= target / 2) {
                    int tmp = Arrays.binarySearch(nums, ++count, tnum.length, target - i);
                    if (tmp >= 0 && tmp < nums.length) {
                        // System.out.println(tmp);
                        ans1 = i;
                        ans2 = nums[tmp];
                        // System.out.println(ans1);
                        // System.out.println(ans2);
                    }

                }

            }
        }

        int[] ind = { -1, -1 };
        for (int i = 0; i < tnum.length; ++i) {
            if (ind[0] != -1 && ind[1] != -1) {
                break;
            }
            if (tnum[i] == ans1) {
                ind[0] = i;
            } else if (tnum[i] == ans2) {
                ind[1] = i;
            }
        }
        return ind;
    }
}