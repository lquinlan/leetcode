public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int last=0;
        int maxid=0;
        int maxtime=0;
        for(var log:logs){
            int tmp=log[1]-last;
            if(tmp==maxtime){
                maxid=Math.min(maxid, log[0]);
            }else if(tmp>maxtime){
                maxtime=tmp;
                maxid=log[0];
            }
            last=log[1];
        }
        return maxid;

    }
}
