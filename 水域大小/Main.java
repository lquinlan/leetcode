import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    int[][] ind = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int[] pondSizes(int[][] land) {
        List<Integer> res=new ArrayList<Integer>();
        boolean[][] vis = new boolean[land.length][land[0].length];
        for (int i=0; i<land.length; i++){
            for (int j=0; j<land[i].length; j++){
                if(land[i][j]==0&&!vis[i][j]){
                res.add(dfs(land, vis, i, j));
                }
            }
        } 
        
        return res.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    int dfs(int[][] land ,boolean[][] vis,int i,int j){
        int N=land.length;
        int M=land[0].length;
        int ans=1;
        vis[i][j] =true;
        for(var in:ind){
            int nx=i+in[0];
            int ny=j+in[1];
            if(nx>=0&&nx<N&&ny>=0&&ny<M&&land[nx][ny]==0&&!vis[nx][ny]){
                ans+=dfs(land,vis,nx,ny);
            }
        }
        return ans;
    }
}