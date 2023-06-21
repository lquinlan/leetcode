import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        Solution  solution = new Solution();
        int ans=solution.flipChess(new String[]{".......","X......",".O.....","..O...X","...OOOX","....O..","...OOOX"});
        System.out.println(ans);
        
    }
}

class Solution {
    int N;
    int M;
    int[][] ind=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    Queue<int[]> queue=new LinkedList<int[]>();
    public int flipChess(String[] chessboard) {
        N=chessboard.length;
        M=chessboard[0].length();
        int res=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(chessboard[i].charAt(j)=='.'){
                    res=Math.max(res,bfs(chessboard,i,j));
                }
            }
        }
        return res;

    }
    int bfs(String[] chess,int i,int j){
        boolean[][] vis=new boolean[N][M];
        
        vis[i][j]=true;
        queue.add(new int[]{i,j});
        int ans=0;
        while(!queue.isEmpty()){
            var cur=queue.poll();
            for(var in:ind){
                if(check(cur,in,chess,vis)){
                    int nx=cur[0]+in[0];
                    int ny=cur[1]+in[1];
                    while(chess[nx].charAt(ny)!='X'&&!vis[nx][ny]){
                        ++ans;
                        queue.add(new int[]{nx,ny});
                        vis[nx][ny]=true;
                        nx+=in[0];
                        ny+=in[1];
                    }
                }
            }
        }
        return ans;
    }
    boolean check(int[] cur,int[] ind,String[] chess,boolean[][] vis){
        int nx=cur[0]+ind[0];
        int ny=cur[1]+ind[1];
        if(nx>=0&&nx<N&&ny>=0&&ny<M&&chess[nx].charAt(ny)=='O'&&!vis[nx][ny]){
            while(true){
                nx+=ind[0];
                ny+=ind[1];
                if(nx>=0&&nx<N&&ny>=0&&ny<M){
                    if(chess[nx].charAt(ny)=='X'||vis[nx][ny]){
                        return true;
                    }else if(chess[nx].charAt(ny)=='O'){
                        continue;
                    }else {
                        return false;
                    }   
                }else{
                    return false;
                }
            }

        }else{
            return false;
        }
        

    }
}