import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int r=price[price.length-1]-price[0];
        int l=0;
        int ans=0;
        while(l<=r){
            int mid=(l+r)>>1;
            // System.out.println("mid=="+mid);
            if(check(price, k, mid)){
                l=mid+1;
                // ans=mid;
            }else{
                r=mid-1;
            }
        }
        return r;

    }
    boolean check(int[] price, int k,int limit) {
        int cnt=1;
        int pre=0;
        for(int i=1;i<price.length;++i){
            if(price[i]-price[pre]>=limit){
                ++cnt;
                pre=i;
            }
        }
        return cnt>=k;
    }
}
// 1 2 5 8 13 21