import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
       
        if(nums.length<=1){
            Arrays.stream(nums).boxed().collect(Collectors.toList());
        }
        List<Integer> result = new ArrayList<Integer>();
        int c1=nums[0];
        int cnt1=0;
        int c2=nums[1];
        int cnt2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==c1){
                cnt1++;
            }else if(nums[i]==c2){
                cnt2++;
            }else if(cnt1==0){
                c1=nums[i];
                cnt1=1;
            }else if(cnt2==0){
                c2=nums[i];
                cnt2=1;
            }else{
                --cnt1;
                --cnt2;
            }
        }
        cnt1=0;
        cnt2=0;
        for(var i:nums){
            if(i==c1){
                ++cnt1;
            }
            if(i==c2){
                ++cnt2;
            }
        }
        int thr=nums.length/3;
        if(cnt1>thr){
            result.add(c1);
        }
        if(cnt2>thr&&c1!=c2){
            result.add(c2);
        }
        return result;


    }
}