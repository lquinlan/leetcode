import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {

    }
}

// class Solution {
// public void moveZeroes(int[] nums) {
// List<Integer> ans = new ArrayList<Integer>();
// for (var i : nums) {
// ans.add(i);
// }
// ans.sort(new Comparator<Integer>() {
// public int compare(Integer o1, Integer o2) {
// int a1 = 0;
// int a2 = 0;
// if (o1 == 0) {
// a1 = 9;
// ;
// }
// if (o2 == 0) {
// a2 = 10;
// }
// return a1 - a2;

// }
// });
// for (var i = 0; i < ans.size(); i++) {
// nums[i] = ans.get(i);
// }

// }
// }
// class Solution {
// public void moveZeroes(int[] nums) {
// int curind=0;
// for(int i = 0; i < nums.length; ){
// if(nums[i]!=0){
// nums[curind++]=nums[i];
// }
// }
// while(curind<nums.length){
// nums[curind++]=0;
// }

// }
// }

class Solution {

    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                nums[l] = nums[l] ^ nums[r];
                nums[r] = nums[l] ^ nums[r];
                nums[l] = nums[l] ^ nums[r];
                ++l;
            }
            ++r;
        }

    }
}