
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Solution solution= new Solution();
        int[][] ma={{0,0,1},{1,1,0}};
        System.out.println(solution.maxEqualRowsAfterFlips(ma));
    }
}
// 0 0 1
// 1 0 0
// 0 0 1
// 0 0 1
// 001
// 110



class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0; i<m; i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=0; j<n; j++) {
                char tmp=(char)('0'+matrix[i][j]^matrix[i][0]);
                sb.append(tmp);
               

            }
             map.put(sb.toString(),map.getOrDefault(sb.toString(), 0)+1);
            
        }
        int ans=0;
        for(var i:map.keySet()) {
            ans=Math.max(ans,map.get(i));
        }
        return ans;
    

        
    }
}