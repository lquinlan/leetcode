import java.util.HashMap;
import java.util.Map;

public class MinSubarray {
    public static void main(String[] args) {

    }
}

// class Solution {
// public int minSubarray(int[] nums, int p) {

// }
// }
// 6 3 5 2
// 7

// (a+b)%p=7
// (presumb-presuma+p)%p=7
// (presumb-7+p)%=presuma

class Solution {
    public int minSubarray(int[] nums, int p) {
        int ans = nums.length;
        int mod = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            // sum=(sum+nums[i])%p;
            mod = (mod + num) % p;
            // map.put(sum, i);
        }
        if (mod == 0) {
            return 0;
        }
        // System.out.println(mod);
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
            map.put(sum, i);
            int tar = (sum - mod + p) % p;
            // System.out.println("sum=="+sum);
            // System.out.println("tar="+tar);

            if (map.containsKey(tar)) {
                // System.out.println("i=="+i);
                ans = Math.min(ans, i - map.get(tar));
            }
        }
        if (ans == nums.length) {
            ans = -1;
        }
        return ans;

    }
}