public class Main{

}

class Solution {
    public int pivotInteger(int n) {
        int l=1;
        int r=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            int lsum=(1+mid)*mid/2;
            int rsum=(n+mid)*(n-mid+1)/2;
            if(lsum==rsum){
                return mid;
            }else if(lsum<rsum){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}