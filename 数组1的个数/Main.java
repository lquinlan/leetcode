public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a=solution.countDigitOne(100);
        System.out.println(a);
        
        
    }
}
class Solution {
    public int countDigitOne(int n) {

        int ans=0;
        int i=1;
        for(int k=0;k<10;k++){
            int cnt=(n/(i*10));
            ans+=i*cnt;
            int mod=n%(i*10);
            if(mod<i){
                i=i*10;
                continue;
            }else if(mod>=2*i){
                ans+=i;
            }else {
                ans+=(mod-i+1);
            }
            i=i*10;
            // if(cnt==0){
            //     break;
            // }
        }
        return ans;
    }
}
