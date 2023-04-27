public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp=new int[values.length][values.length];

        for(int i=2; i<dp.length; i++){
            for (int j =i-2 ; j >=0;--j) {
                dp[j][i]=Integer.MAX_VALUE;
                for(int k=j+1;k<i;++k){
                    dp[j][i]=Math.min(dp[j][i], dp[j][k]+dp[k][i]+values[i]*values[j]*values[k]);
                }
            }
        }

        return dp[0][dp.length-1];

    }
}
/*
 * dp[i][j]表示多边形i-j组成的最小值
 * 对于每一次将一个多边形都可以看着两个多边形和一个三角形组成
 * 因此每次dp确定多边形的变现，然后从小到大dp
 * 
 * 
 */