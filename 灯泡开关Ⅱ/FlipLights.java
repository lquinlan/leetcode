public class FlipLights {
    public static void main(String[] args) {

    }
}

class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return (presses == 1) ? 3 : 4;
        }
        return (presses >= 3) ? 8 : (presses == 1) ? 4 : 7;
    }
}
/*
 * 从基向量的角度入手四种操作完全表示至少需要四位
 * 1【1，1，1，1】
 * 2【0，1，0，1】
 * 3【1，0，1，0】
 * 4【1，0，0，1】
 * 其中1，2，4是不相关的，所以解空间为2^3=8
 * 任何一种状态只需要1，2，4的组合即可
 * 所以n>=3,p>=3都是8只需要在考虑个别情况即可
 */