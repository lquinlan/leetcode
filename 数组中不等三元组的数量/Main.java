public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int unequalTriplets(int[] nums) {
        int[] map = new int[1003];
        for(var i:nums){
            map[i]++;
        }
        int ans=0;
        int t=0;
        for(var i:map){
            if(i!=0){
                ans+=t*i*(nums.length-i-t);
                t+=i;
            }
        }
        return ans;
    }
}