import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j=Arrays.binarySearch(numbers, i+1, numbers.length, target-numbers[i]);
            if(j<0){
                continue;
            }else{
                return new int[] { i+1, j+1 };

            }
               
            
        }
        return null;

    }
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length;
        while(l<r){
            // if(numbers[l]==numbers[r]){
            //     ++r;
            // }
            if(numbers[r]+numbers[l]==target){
                return new int[] { l+1, r+1 };
            }
            if(numbers[l]+numbers[r]<target){
                ++l;
            }else{
                ++r;
            }
        }
        return null;

    }
}