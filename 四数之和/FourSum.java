import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int tr = target;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                target = tr - (nums[i] + nums[j]);
                int right = nums.length - 1;

                for (int l = j + 1; l < nums.length; l++) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        continue;
                    }
                    while (l < right && nums[l] + nums[right] > target) {
                        --right;
                    }
                    if (l == right) {
                        break;
                    }
                    if (nums[l] + nums[right] == target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l]);
                        tmp.add(nums[right]);
                        result.add(tmp);
                    }
                }
            }
        }
        return result;

    }
}