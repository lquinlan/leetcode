import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int[][] ind = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    Queue<State> stateQueue = new LinkedList<State>();
    short[][][][] vis;
    int[][][][] step;

    
    class State {
        int sx; 
        int sy;
        int bx; 
        int by; 
        int step; 

        public State(int sx, int sy, int bx, int by, int step) {
            this.sx = sx;
            this.sy = sy;
            this.bx = bx;
            this.by = by;
            this.step = step;
        }
        @Override
        public String toString() {
            return "State [sx=" + sx + ", sy=" + sy + ", bx=" + bx + ", by=" + by + ", step=" + step + "]";
        }
    }

   
    boolean isValid(int x, int y, char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }

    public int minPushBox(char[][] grid) {
        vis =new short[grid.length][grid[0].length][grid.length][grid[0].length];
        // step =new int[grid.length][grid[0].length][grid.length][grid[0].length];
        int sx=0,sy=0,bx=0,by=0,tx=0,ty=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]=='S'){
                    sx=i;
                    sy=j;
                }
                if(grid[i][j]=='B'){
                    bx=i;
                    by=j;
                }
                if(grid[i][j]=='T'){
                    tx=i;
                    ty=j;
                }
            }
        }

        vis[sx][sy][bx][by]=1;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                for(int k=0;k<grid.length;++k){
                    Arrays.fill(step[i][i][k],Integer.MAX_VALUE);
                }
            }
        }
        step[sx][sy][bx][by]=0;
        

        stateQueue.add(new State(sx, sy, bx, by, 0));
        while(!stateQueue.isEmpty()){
            var cur=stateQueue.poll();
            System.out.println(cur);
            if(cur.bx==tx&&cur.by==ty){
                return cur.step;
            }
            for(int i=0;i<4;++i){
                int nextx=cur.sx+ind[i][0];
                int nexty=cur.sy+ind[i][1];
                // int step=vis[cur.sx][cur.sy][cur.bx][cur.by];
                if(isValid(nextx, nexty, grid)){
                    int nbx=cur.bx;
                    int nby=cur.by;
                    // int step=0;
                    if(nextx==cur.bx&&nexty==cur.by){
                        nbx+=ind[i][0];
                        nby+=ind[i][1];
                        // step=1;
                        if(isValid(nbx, nby, grid)){
                            if(vis[nextx][nexty][nbx][nby]==0&&step[nextx][nexty][nbx][nby]>step[cur.sx][cur.sy][cur.bx][cur.by]+1){
                                stateQueue.add(new State(nextx, nexty, nbx, nby,cur.step+1));
                                vis[nextx][nexty][nbx][nby]=1;
                                step[nextx][nexty][nbx][nby]=step[cur.sx][cur.sy][cur.bx][cur.by]+1;

                            }
                        }
                    }else{
                        if(vis[nextx][nexty][nbx][nby]==0){
                            stateQueue.add(new State(nextx, nexty, nbx, nby,cur.step));
                            vis[nextx][nexty][nbx][nby]=1;
                            
                        }

                    }
                   
                }

            }
        }

        return -1;


    }
}
