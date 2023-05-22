public class Main{
    public static void main(String[] args) {
        
    }
}
// class Solution {
//     // you need treat n as an unsigned value
//     public int reverseBits(int n) {
//         int res = 0;
//         for(int i = 0; i < 32; i++){
//             res = res << 1;
//             res = res | (n & 1);
//             n = n >>> 1;
//         }
//         return res;
        
//     }
// }
// 分治位运算
/*
 * 简单理解，对于一个翻转问题可以采用分支的方法来处理，先分别翻转左右两部分，再反过来拼接
 * 如1234
 * 12   34
 * 1 2  3  4
 * 21    43
 * 4321
 * 当次数不多时，是可以简单总结规律的，第一次翻转发生在奇偶，第二次各有各翻转一次
 * 32位只需要五次
 * 01010101
 * 00110011
 * 00001111
 */
class Solution {
    private static final int m1=0x55555555;
    private static final int m2=0x33333333;
    private static final int m3=0x0f0f0f0f;
    private static final int m4=0x00ff00ff;
    private static final int m5=0x0000ffff;
    public int reverseBits(int n) {
        n=(n>>>1)&m1|(n&m1)<<1;
        n=(n>>>2)&m2|(n&m2)<<2;
        n=(n>>>4)&m3|(n&m3)<<4;
        n=(n>>>8)&m4|(n&m4)<<8;
        n=(n>>>16)&m5|(n&m5)<<16;
        return n;
        
    }
}