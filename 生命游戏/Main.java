import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public void gameOfLife(int[][] board) {
        int N=board.length;
        int M=board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int s=check(board,i,j);
                if(board[i][j]==1&&s<2){
                    // board[i][j]=0;
                    queue.add(new int[]{i,j});
                }else if(board[i][j]==1&&s>3){
                    // board[i][j]=0;
                    queue.add(new int[]{i,j});
                }else if(board[i][j]==0&&s==3){
                    // board[i][j]=1;
                    queue.add(new int[]{i,j});   
                }
            }
        }
        // board.toString();
        while(!queue.isEmpty()){
            // while(!queue.isEmpty()){
                var ind=queue.poll();
                board[ind[0]][ind[1]]^=1;

            // }
           
            // for(int i = 0; i < board.length; i++){
            //     for(int j = 0; j < board[i].length; j++){
            //         int s=check(board,i,j);
            //         if(board[i][j]==1&&s<2){
            //             // board[i][j]=0;
            //             queue.add(new int[]{i,j});
            //         }else if(board[i][j]==1&&s>3){
            //             // board[i][j]=0;
            //             queue.add(new int[]{i,j});
            //         }else if(board[i][j]==0&&s==3){
            //             // board[i][j]=1;
            //             queue.add(new int[]{i,j});   
            //         }
            //     }
            // }

        }

    }
    int check(int[][] board,int x,int y){
        int N=board.length;
        int M=board[x].length;
        int sum=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0&&j==0){
                    continue;
                }
                int nx=x+i;
                int ny=y+j;
                if(nx>=0&&nx<N&&ny>=0&&ny<M){
                    sum+=board[nx][ny];
                }
            }
        }
        return sum;
    }
}