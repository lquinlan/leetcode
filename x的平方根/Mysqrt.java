public class Mysqrt {
    public static void main(String[] args) {

    }
}

class Solution {
    public int mySqrt(int x) {
        double a = x;
        double x0 = 3;
        double x1 = 1;
        while (Math.abs(x1 - x0) < 0.001) {
            x0 = x1;
            x1 = x0 - (x0 * x0 - a) / (2 * x0);
            System.out.println(x1);

        }
        // System.out.println(x1);
        int ans = (int) x1;
        return ans;

    }
}