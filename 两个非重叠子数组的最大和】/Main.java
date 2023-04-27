public class Main{
    public static void main(String[] args) {
        
    }
}
// 暴力
// class Solution {
//     public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
//         int ans=Integer.MIN_VALUE;
//         int[] presum=new int[nums.length+1];
//         for(int i=0; i<nums.length; i++){
//             presum[i+1]=nums[i]+presum[i];
//         }

//         for(int i=0; i+firstLen<=nums.length; i++){
//             int l1=i;
//             int l2=i+firstLen;

//             for(int j=0; j+secondLen<=nums.length; j++){
//                 if((j<l1&&(j+secondLen)<=l1)||j>l2){
//                     int r1=j;
//                     int r2=j+secondLen;
//                     ans=Math.max(ans, presum[l2]-presum[l1]+presum[r2]-presum[r1]);
                    
//                 }

//             }
//         }
//         return ans;

//     }
// }

// 优化，滑动窗口+dp
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(dp(nums,firstLen,secondLen), dp(nums,secondLen,firstLen));

    }

    int dp(int[] nums,int firstLen,int secondLen){
        int suml=0;
        for(int i=0;i<firstLen;++i){
            suml+=nums[i];
        }
        int maxsuml=suml;
        int sumr=0;
        for(int i=firstLen;i<firstLen+secondLen;++i){
            sumr+=nums[i];
        }
        int ans=maxsuml+sumr;
        for(int i=firstLen,j=firstLen+secondLen;j<nums.length;++j,++i){
            suml+=nums[i]-nums[i-firstLen];
            maxsuml=Math.max(maxsuml,suml);
            sumr+=nums[j]-nums[j-secondLen];
            ans=Math.max(ans,maxsuml+sumr);

        }
        return ans;

    }
}