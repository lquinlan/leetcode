public class Main1 {
    
}

class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1){
            return 1;
        }
        int[] map=new int[128];
        
        for(var i:s.toCharArray()){
           map[i]++;
        }
        int ans=0;
        int cnt=0;
        for(var i:map){
            if(i>0&&(i&1)==0){
                ans+=i;;
            }else if(i>0){
                ans+=(i-1);
                cnt=1;
            }
        }

        return ans+cnt;
        

    }
}