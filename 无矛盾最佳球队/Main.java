import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    int[][] pair=null;                                           
    int[] dp=null;
    int N=0;
    public int bestTeamScore(int[] scores, int[] ages) {
        int ans=0;
        N = scores.length;
        pair=new int[N][2];
        dp=new int[N];
        for(int i=0;i<N;i++){
            pair[i][0]=scores[i];
            pair[i][1] = ages[i];
        }
        Arrays.sort(pair,(int[] p1,int[] p2)->{
            if(p1[0]!=p2[0]){
                return p1[0]-p2[0];
            }else{ 
                return p1[1]-p1[1];
            }
            
        });
        dp[0]=pair[0][0];
        ans=dp[0];
        for(int i=1;i<N;++i){
            int tmp=pair[i][0];
            for(int j=0;j<i;++j){
                if(pair[j][1]<=pair[i][1]){
                    tmp=Math.max(tmp,dp[j]+pair[i][0]);
                }
            }
            dp[i]=tmp;
            ans=Math.max(ans, dp[i]);
        }
        return ans;

        


    }
}