public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int equalPairs(int[][] grid) {
        int ans=0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length;j++){
                boolean found=true;
                for(int k=0; k<grid.length; k++){
                    if(grid[k][j]!=grid[i][k]){
                        found=false;
                        break;
                    }
                }
                if(found) ++ans;

            }
        }
        return ans;

    }
}