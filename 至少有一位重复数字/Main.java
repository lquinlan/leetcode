import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    int dp[][]=null;
    List<Integer> list = new ArrayList<Integer>();
    int len=0;
    int dfs(int i,boolean same,int mask){
        if(i<0){
            return 1;
        }
        if(!same&&dp[i][mask]>=0){
            return dp[i][mask];
        }
        int ans=0;
        int curtmp=same?list.get(i):9;
        for(int k=0;k<curtmp;++k){
            if((mask&(1<<k))!=0){
                continue;
            }
            ans+=dfs(i-1,(same&&(k==curtmp)),(mask==0&&k==0)?mask:(mask|(1<<k)));
        }
        if(!same){
            dp[i][mask]=ans;
        }
        return ans;
    }
    public int numDupDigitsAtMostN(int n) {

        while (n > 0) {
            list.add(n%10);
            n /= 10;
        }
        dp=new int[list.size()][1<<10];
        len = list.size();
        if(len<=1){
            return 0;
        }
        for (int i = 0; i < list.size();++i ) {
            Arrays.fill(dp[i], -1);
        }
        return n+1-dfs(len-1,true,0);


    }
}