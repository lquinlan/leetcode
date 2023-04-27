public class RemoveElement {
    public static void main(String[] args) {

    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int newend = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newend++] = nums[i];
            }
        }
        return newend;

    }
}