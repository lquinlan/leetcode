import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<Boolean>();
        int[] presumed = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            presumed[i+1] =presumed[i]^(1<<('a'-s.charAt(i)));
        }
        for(var i:queries){
            int l=i[0];
            int r=i[1];
            int k=i[2];
            if(r-l==0){
                result.add(true);
            }else{
                int odd=presumed[r+1]^presumed[l];
                int cnt=Integer.bitCount(odd);
                // System.out.println(k);
                // System.out.println(cnt);
                if(k>=cnt/2){
                    result.add(true);
                }else{
                    result.add(false);
                }

            }
        }
        return result;
        

    }
}