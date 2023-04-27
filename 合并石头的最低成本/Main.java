public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int mergeStones(int[] stones, int k) {
       if((stones.length-1)%(k-1) != 0){
        return -1;
       }
       int[] prefixsum = new int[stones.length+1];
       int length =stones.length;
       for(int i=1;i<=length;i++){
            prefixsum[i]=prefixsum[i-1]+stones[i-1];
       }
       int[][][] dp=new int[length+1][length+1][k+1];
       for(int len=k;len<=length;len++){
            for(int i=0;i+len<=length;i++){
                int j=i+len-1;
                for(int t=2;t<=k;t++){
                    dp[i][j][t]=Integer.MAX_VALUE;
                    for(int m=i;m<j;m+=k-1){
                        dp[i][j][t]=Math.min(dp[i][j][t],dp[i][m][1]+dp[m+1][j][t-1]);
                    }
                }
                dp[i][j][1]=dp[i][j][k]+prefixsum[j+1]-prefixsum[i];
                // System.out.println("i="+i+" j="+j);
                // System.out.println("sum="+(prefixsum[j+1]-prefixsum[i]));
                
            }
            

       }
    //    for(int i=0;i<=length;++i){
    //        for(int j=0;j<=length;++j){
    //            System.out.print(dp[i][j][1]+" ");
    //        }
    //        System.out.println();
    //    }




       return dp[0][length-1][1];

    }
}