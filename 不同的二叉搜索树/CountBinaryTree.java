public class CountBinaryTree {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numTrees(int n) {
        long c0 = 1;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = 2 * (2 * i + 1) * c0 / (i + 2);
            c0 = ans;
        }
        return (int) ans;

    }
}