public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=gas.length-1;
        int end=0;
        int sum=gas[start]-cost[start];
        int N=gas.length;
        while(start!=end){
            if(sum>=0){
                sum+=gas[end]-cost[end];
                end=(end+1)%N;
            }else {
                start=(start-1+N)%N;
                sum += gas[start] -cost[start];
            }
        }
        if(sum<0){
            return -1;
        }else {
            return start; 
        }

    }
}