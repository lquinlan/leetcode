import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] h = { -1, 0, 1, 2, -1, -4 };
        solution.threeSum(h);

    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        int k = -1;
        Arrays.sort(nums);
        int li = 999999;
        int lj = 999999;
        for (int i = 0; i < nums.length; ++i) {
            if (li == 999999) {
                li = nums[i];
            } else if (nums[i] == li) {
                continue;
            } else {
                li = nums[i];
            }
            for (int j = i + 1; j < nums.length - 1; ++j) {
                if (lj == 999999) {
                    lj = nums[j];
                } else if (nums[j] == lj) {
                    continue;
                } else {
                    lj = nums[j];
                }

                int find = -(nums[i] + nums[j]);
                if ((k = Arrays.binarySearch(nums, j + 1, nums.length, find)) >= 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    // tmp.clear();
                }
            }
            lj = 999999;
        }
        return result;
    }
}
