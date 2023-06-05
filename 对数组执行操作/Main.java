public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]==0){
                continue;
            }else if(nums[i]==nums[i+1]){
                nums[i] =nums[i]*2;
                nums[i+1] =0;
            }
        }
        int[] result = new int[nums.length];
        int i=0;int j=nums.length-1;int k=0;
        while(i<=j){
            if(nums[k]==0){
                result[j--] =nums[k++];
            }else{
                result[i++] =nums[k++];
            }
        }
        return result;
        

    }
}