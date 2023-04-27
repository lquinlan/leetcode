import java.util.HashSet;

public class OnlyOneNumber {
    public static void main(String[] args) {

    }
}

// 去重
class Solution1 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (var i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        for (var i : set) {
            return i;
        }
        return 0;
    }
}

// 异或
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (var i : nums) {
            ans = ans ^ i;
        }
        return ans;
    }
}