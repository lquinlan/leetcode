import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSeq {
    public static void main(String[] args) {

    }
}

// 哈希
class Solution {
    public int longestConsecutive(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> map = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            map.add(nums[i]);
        }
        int longest = 0;
        for (var i : map) {
            if (!map.contains(nums[i] - 1)) {
                int curnum = nums[i];
                int curlong = 1;
                while (map.contains(curnum + 1)) {
                    ++curlong;
                    ++curnum;
                }
                longest = curlong > longest ? curlong : longest;

            }
        }

        return longest;

    }
}

class Solution1 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 0;
        int curlong = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else if ((nums[i] + 1) == nums[i + 1]) {
                ++curlong;

            } else {
                longest = Math.max(curlong, longest);
                curlong = 1;
            }
        }
        longest = Math.max(curlong, longest);

        return longest;

    }
}