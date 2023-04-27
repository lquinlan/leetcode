import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

}

class Solution {
    public int countSubarrays(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        int ink = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == k) {
                ink = i;
                break;
            }

        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        for (int i = ink - 1; i >= 0; --i) {
            if (i < 0) {
                break;
            
            }

            sum += (nums[i] < k ? -1 : 1);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // System.out.println("sum== "+sum);
        }
        int sum1 = 0;
        for (int i = ink; i < nums.length; ++i) {
            if (i == ink) {
                ans += map.getOrDefault(0 - sum1, 0);
                ans += map.getOrDefault(1 - sum1, 0);
                // System.out.println("ans== "+ans);

            } else {
                sum1 += (nums[i] < k ? -1 : 1);
                // System.out.println("sum1== "+sum1);

                ans += map.getOrDefault(0 - sum1, 0);
                ans += map.getOrDefault(1 - sum1, 0);
            }

        }

        return ans;

    }
}
