import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        if(n==1){
            return 1;
        }
        int[] dp= new int[1<<n];
        int[] need=new int[1<<n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(var i:relations){
            need[1<<(i[0]-1)]|=1<<(i[1]-1);
        }
        dp[0]=0;
        need[0]=0;
        for(int i=1;i<(1<<n);i++){
            need[i]=need[i&(i-1)]|need[i&(-i)];
            if((need[i]|i)!=i){
                continue;
            }
            int vaild=i^need[i];
            if(Integer.bitCount(vaild)<=k){
                dp[i]=Math.min(dp[i],dp[i^vaild]+1);
            }else{
                for(int sub=vaild;sub>0;sub=(sub-1)&vaild){
                    if(Integer.bitCount(sub)<=k){
                        dp[i]=Math.min(dp[i],dp[i^sub]+1);
                    }
                }
            }
        }
        return dp[(1<<n)-1];

    }
}