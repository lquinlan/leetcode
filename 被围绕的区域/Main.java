import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    int[][] vis=null;
    int[][] dis={{1,0},{-1,0},{0,1},{0,-1}};
    Queue<pair> queue = new LinkedList<>();
    int leni;
    int lenj;
    boolean bfs(char[][] board){
        List<pair> tmp = new LinkedList<>();
        boolean f=true;
        int size=queue.size();
        for(int s=0;s<size;s++){
            pair p = queue.poll();
            int i=p.i;
            int j=p.j;
            
            if(i==0||i==leni-1||j==0||j==lenj-1){
                        f=false;
            }
           
            for(int k=0;k<4;++k){
                int x=dis[k][0];
                int y=dis[k][1];
                int nexti=i+x;
                int nextj=j+y;
               
                if(nexti>=0&&nexti<leni&&nextj>=0&&nextj<lenj&&board[nexti][nextj]=='O'&&vis[nexti][nextj]==0){
                    System.out.print(nexti);
                    System.out.println(" "+nextj);
                    vis[nexti][nextj]=1;
                    if(nexti==0||nexti==leni-1||nextj==0||nextj==lenj-1){
                        f=false;
                    }
                    queue.add(new pair(nexti,nextj));
                    tmp.add(new pair(nexti,nextj));
                }
            }

        }
  
        if(queue.size() > 0){
            if(bfs(board)&&f){
                for(pair tp:tmp){
                    board[tp.i][tp.j]='X';

                }
                return f;
            }else{
                return false;
            }

        }else { 
            return f;
        }

    }
    public void solve(char[][] board) {
        leni=board.length;
        lenj=board[0].length;
        vis=new int[leni][lenj];
        for(int i = 0; i < leni; i++){
            for (int j = 0; j < lenj; j++) {
                if(board[i][j] =='O'&&vis[i][j]==0){
                    // System.out.println("fd");
                    queue.add(new pair(i, j));
                     System.out.print(i);
                System.out.println(" "+j);
                    vis[i][j]=1;
                   if(bfs(board)){
                       board[i][j]='X';
                   }
                }
                

             }
        }

        

    }
}
class pair{
    int i;
    int j;
    pair(int i, int j) { 
        this.i = i;
        this.j = j;
    }

}