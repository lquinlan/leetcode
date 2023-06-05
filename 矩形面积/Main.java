public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int r1=(ax2-ax1)*(ay2-ay1);
        // System.out.println("r1=="+r1);
        int r2=(bx2-bx1)*(by2-by1);
        // System.out.println("r2=="+r2);
        int cx1=Math.max(ax1,bx1);
        int cx2=Math.min(ax2,bx2);
        int cy1=Math.max(ay1,by1);
        int cy2=Math.min(ay2,by2);
        int r3=(cx2-cx1)*(cy2-cy1);
        if(cx2-cx1<0||cy2-cy1<0){
            r3=0;
        }
        return r1+r2-r3;
    }
}