public class ProductExceptSelf {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preproduct = new int[nums.length];
        int[] postproduct = new int[nums.length];
        int[] result = new int[nums.length];
        preproduct[0] = 1;
        postproduct[nums.length - 1] = 1;
        for (int i = 1; i < preproduct.length; i++) {
            preproduct[i] = preproduct[i - 1] * nums[i - 1];
            postproduct[nums.length - i - 1] = postproduct[nums.length - i] * nums[nums.length - i];
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = preproduct[i] * postproduct[i];
        }

        return result;

    }
}