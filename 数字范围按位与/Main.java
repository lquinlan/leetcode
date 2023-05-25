public class Main{

}
// class Solution {
//     public int rangeBitwiseAnd(int left, int right) {
//         if(left==right) return left;

//         int res=0;
//         for(int i=31;i>=0;--i){
//             int a1=left>>i;
//             int a2=right>>i;
//             if(a1==a2) {
//                 res=(res|1<<i);
//             }else{
//                 return res;
//             }
//         }
//         return res;

//     }
// }
// 更简洁写法
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}