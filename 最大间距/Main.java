// import java.nio.Buffer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        if(nums.length==2){
            return Math.abs(nums[0]-nums[1]);
        }
        int max=nums[0];
        int min=nums[0];
        for(var num:nums){
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        // System.out.println(max+" "+min);
        int d=Math.max(1,(max-min)/(nums.length-1));
        int dsize=(max-min)/d+1;
        // System.out.println(d+" "+dsize);
        int[][] buffer=new int[dsize][2];

         for(int i=0;i<dsize;++i){
            Arrays.fill(buffer[i],-1);
        }
        for(int i=0;i<nums.length;i++){
            int ind=(nums[i]-min)/d;
            if(buffer[ind][0]==-1){
                buffer[ind][0]=buffer[ind][1]=nums[i];
            }else{
                buffer[ind][0]=Math.min(buffer[ind][0],nums[i]);
                buffer[ind][1]=Math.max(buffer[ind][1],nums[i]);
            }
        }
        int ans=0;
        int pre=-1;
        for(int i=0;i<dsize;++i){
            if(buffer[i][0]==-1){
                continue;
            }
            if(pre!=-1){
                ans=Math.max(ans,buffer[i][0]-buffer[pre][1]);
            }
            pre=i;
        }
        return ans;


    }
}