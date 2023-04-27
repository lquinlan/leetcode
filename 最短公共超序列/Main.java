public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) { 
            dp[i][m]=n-i;
        }
        for(int i=0;i<m;++i){
            dp[n][i]=m-i;

        }
        for(int i=n-1;i>=0;--i) {
            for(int j=m-1;j>=0;--j) {
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }else { 
                    dp[i][j] = Math.min(dp[i+1][j]+1,dp[i][j+1]+1);
                }
            }
        }
        int i=0,j=0;
        StringBuilder answer = new StringBuilder();
        while(i<n&&j<m){
            if(str1.charAt(i)==str2.charAt(j)){
                answer.append(str1.charAt(i));
                ++i;
                ++j;
            }else if(dp[i+1][j]<dp[i][j+1]){
                answer.append(str1.charAt(i));
                ++i;
            }else { 
                answer.append(str2.charAt(j));
                ++j;
            }

        }
        if(i<n){
            answer.append(str1.substring(i, n));
        }
        else { 
            answer.append(str2.substring(j, m));
        }
        return answer.toString();


    }
}