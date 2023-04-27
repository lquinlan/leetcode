public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;++i){
            for(var j:nums){
                int sum=0;
                sum+=((j>>i)&1);
                if(sum%3!=0){
                    ans|=(1<<i);
                }
            }
        }
        return ans;

    }
}