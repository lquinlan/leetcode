import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {

    }
}

// class Solution {
// public int subarraySum(int[] nums, int k) {
// int[] presum = new int[nums.length + 1];
// presum[0] = 0;
// for (int i = 0; i < nums.length; i++) {
// presum[i + 1] = presum[i] + nums[i];

// }
// int ans = 0;
// for (int i = 0; i < nums.length; i++) {
// for (int j = i; j < nums.length; j++) {
// if (k == (presum[j + 1] - presum[i])) {
// ++ans;

// }

// }
// }
// return ans;

// }
// }
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);

            }

            // map.put(sum - k, map.getOrDefault(sum - k, 0) + 1);
            if (map.containsKey(sum)) {
                map.replace(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }

        }
        return ans;

    }
}