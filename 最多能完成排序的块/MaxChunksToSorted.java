public class MaxChunksToSorted {
    public static void main(String[] args) {

    }

}

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = -1;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;

            }
        }
        return ans;
    }
}