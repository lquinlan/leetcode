public class Trap {
    public static void main(String[] args) {

    }
}

class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int l = 0;
        int r = height.length - 1;
        int lmax = 0;
        int rmax = r;
        while (l < r) {
            if (height[l] >= height[lmax]) {
                lmax = l;
            }
            if (height[r] >= height[rmax]) {
                rmax = r;
            }
            if (height[l] < height[r]) {
                sum += height[lmax] - height[l];
                ++l;

            } else {
                sum += height[rmax] - height[r];
                --r;
            }
        }

        return sum;

    }
}