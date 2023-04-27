public class MidNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l1 = {};
        int[] l2 = { 3, 4 };
        System.out.println(solution.findMedianSortedArrays(l1, l2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = (nums1.length + nums2.length);
        int mid = l / 2;
        int count = 0;
        int i = 0;
        int j = 0;

        int ans1 = 0;
        int ans2 = ans1;
        while (i < nums1.length && j < nums2.length) {
            if (count > mid) {
                break;
            }
            if (nums1[i] <= nums2[j]) {
                ans2 = ans1;
                ans1 = nums1[i];
                // l_i = i - 1;
                // l_j++;
                ++i;
            } else {
                ans2 = ans1;
                ans1 = nums2[j];
                // l_j = j - 1;
                // l_i++;
                ++j;
            }
            ++count;

        }
        // System.out.println("ans1=" + ans1);
        // System.out.println("count=" + count);

        while (i < nums1.length) {
            if (count > mid) {
                break;
            }
            ans2 = ans1;
            ans1 = nums1[i];
            // l_i = i - 1;
            // l_j++;
            ++i;
            ++count;
        }
        // System.out.println("ans1=" + ans1);
        // System.out.println("count=" + count);
        while (j < nums2.length) {
            if (count > mid) {
                break;
            }
            ans2 = ans1;
            ans1 = nums2[j];
            // l_j = j - 1;
            // l_i++;
            ++j;
            ++count;
        }
        // System.out.println("ans1=" + ans1);
        // System.out.println("l_i" + l_i);
        // System.out.println("l_j" + l_j);
        if (l % 2 == 0) {
            return (ans1 * 1.0 + ans2) / 2.0;
        } else {
            return ans1;
        }

    }

}
