import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        queue.add(1L);
        set.add(1L);
        int ans=0;
        long i=0L;
        while(ans<n){
            ++ans;
            i=queue.poll();
            Long j1=i*2;
            Long j2=i*3;
            Long j3=i*5;
            if(set.add(j1)){
                queue.add(j1);
            }
            if(set.add(j2)){
                queue.add(j2);
            }
            if(set.add(j3)){
                queue.add(j3);
            }
        }
        return (int)i;

    }
}