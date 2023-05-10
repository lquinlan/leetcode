public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%10!=1&&k%10!=3&&k%10!=7&&k%10!=9){
            return -1;
        }
        if(k==1){
            return 1;
        }
        int mod=1;
        for(int i=1;i<k;++i){
            mod=(mod*10+1)%k;
            if(mod==0){
                return i+1;
            }
        }
        return -1;

    }
}