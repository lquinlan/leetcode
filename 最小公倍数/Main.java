public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    int gcd(int a,int b){
        if(a%b==0){
            return b;
        }else {
            return gcd(b,a%b);
        
        }
    }
    public int smallestEvenMultiple(int n) {
        return 2*n/gcd(2,n);
    }
}