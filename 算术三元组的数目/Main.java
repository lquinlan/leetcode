public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int[] hash = new int[205];
        int ans=0;
        for(var i:nums){
            if(i-diff<0){
                hash[i]=1;
                continue;
            }
            if(hash[i-diff]==0){
                hash[i]=1;
            }
            if(hash[i-diff]==1){
                hash[i]=2;
            }else if(hash[i - diff] == 2){
                hash[i] = 2;
                ++ans;
            }
        }
        return ans;

    }
}