import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp=new int[nums.length+1][3];
        Arrays.fill(dp[0],Integer.MIN_VALUE);
        dp[0][0]=0;
        for(int i=0;i<nums.length;i++){
            int mod=nums[i]%3;
            for(int j=0;j<3;j++){
                dp[i+1][j]=Math.max(dp[i][j],dp[i][(j-mod+3)%3]+nums[i]);
            }
        }
        return dp[nums.length][0];
    }
}
