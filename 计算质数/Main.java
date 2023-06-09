import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int countPrimes(int n) {
      
        boolean[] isprimes = new boolean[n+1];
        int[] primes=new int[n];
        
        Arrays.fill(isprimes,true);
        int count=0;
        for(int i=2;i<=n;i++){
           
            if(isprimes[i]){
                primes[count++]=i;
            }
            for(int j=0;j<count&&i*primes[j]<=n;j++){
                isprimes[i*primes[j]]=false;
                if(i%primes[j]==0){
                    break;
                }
            }
            
        }
        return count;

    }
}