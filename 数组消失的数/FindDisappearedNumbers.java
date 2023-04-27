import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (var i : nums) {
            nums[i] = (i - 1) % nums.length + nums.length;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (var i : nums) {
            if (i <= nums.length) {
                result.add(i);
            }
        }
        return result;

    }
}