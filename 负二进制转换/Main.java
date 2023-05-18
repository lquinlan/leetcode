public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.baseNeg2(-2));
        
    }
}

class Solution {
    public String baseNeg2(int n) {
        if(n==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) { 
            int i=n&1;
            sb.append(i);
            n-=i;
            n/=-2;

        }
        return sb.reverse().toString();

    }
}