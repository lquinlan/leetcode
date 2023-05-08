public class Main{
    public static void main(String[] args){
        // System.out.println("Hello World");
    }
}
// 正常计算中值会偏左，所有使用mid+1不会有遗漏和越界的问题
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid ;
            }else{
                left = mid-1;
            }
        }
        return left;

    }
}
// 稍微修改可以使用mid-1
class Solution0 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left+1) / 2;
            if( nums[mid] > nums[mid -1]){
                left = mid ;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}

class Solution1{
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[(mid -1)<0?0:mid-1] <=nums[mid] && nums[mid] > nums[mid + 1]) {
                // 找到峰值
                return mid;
            } else if (nums[(mid -1)<0?0:mid-1] <= nums[mid] && nums[mid] < nums[mid + 1]) {
                // 峰值在右半部分
                left = mid + 1;
            } else {
                // 峰值在左半部分
                right = mid - 1;
            }
        }
        // left 和 right 相等，找到了峰值
        return left;
    }
}