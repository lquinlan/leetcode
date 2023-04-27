import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            int tmpmax=arr[i];
            dp[i]=dp[i-1]+tmpmax;
            for(int j=i-1;j>=0&&(i-j)<k;--j){
                tmpmax=Math.max(tmpmax,arr[j]);
                int presum=0;
                if(j!=0){
                    presum=dp[j-1];
                }
                dp[i]=Math.max(dp[i],presum+tmpmax*(i-j+1));
            }
            

        }
        return dp[dp.length-1];

    }
}
