public class PrintBin {
    public static void main(String[] args) {

    }
}

class Solution {
    public String printBin(double num) {
        final double esp = 1e-8;

        StringBuilder ans = new StringBuilder("0.");
        int cnt = 0;
        double tmp = num;
        while (true) {

            tmp = tmp * 2;
            ++cnt;
            if (tmp > 1.0) {
                ans.append("1");
                tmp = tmp - 1;
            } else {
                ans.append("0");
            }
            if (Math.abs(tmp - 1.0) < esp) {
                return ans.toString();
            }
            if (cnt > 30) {
                return "error";
            }

        }

        // return null;

    }
}
// 0.625
// 0.625*2=1.25*2=0.5*2=1