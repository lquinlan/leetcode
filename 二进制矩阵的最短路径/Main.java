import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        int N=grid.length;
        if(N==1){
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0,0});
        int ans=1;
        int[][] vis=new int[grid.length+1][grid.length+1];
        vis[0][0]=1;
        while(!queue.isEmpty()) {
            int s=queue.size();
            ++ans;
            for(int i=0;i<s;i++){
                var next=check(queue.poll(),vis,grid,N);
                for(var arr :next){
                    if(arr[0]==N-1&&arr[1]==N-1){
                        return ans;
                    }
                    queue.add(arr);
                }
            }

        }
        return -1;
    }

    List<int[]> check(int[] node,int[][] vis,int[][] grid,int N){
        List<int[]> res = new ArrayList<int[]>();
        int x=node[0];
        int y=node[1];
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0&&j==0){
                    continue;
                }
                int nx=x+i;
                int ny=y+j;
                if(nx>=0&&nx<N&&ny>=0&&ny<N&&grid[nx][ny]==0&&vis[nx][ny]==0){
                    res.add(new int[]{nx,ny});
                    vis[nx][ny]=1;
                }
            }
        }

        return res;
        
    }
}