import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<Boolean>();
        if(nums.length==1||nums.length==2){
            for (int i = 0; i < nums.length; i++) {
                answer.add(true);
            }

        }
        for(int i=0;i<l.length;++i) {

            int s=l[i];
            int e=r[i];
            answer.add(check(nums,s,e));

        }

        return answer;

    }
    static boolean check(int[]nums,int l,int r){
        if((r-l)+1<3){
            return true;
        }
        int[] tmp=subArray(nums, l, r);
        Arrays.sort(tmp);
        int d=tmp[1]-tmp[0];
        for(int i = 1; i < tmp.length-1; ++i){
            if(tmp[i+1]-tmp[i]!=d){
                return false;
            }
        }
        return true;
    }
    static int[] subArray(int[] nums, int l, int r) {
        int[] tmp=new int[r-l+1];
        for(int i=l;i<=r;++i){
            tmp[i-l]=nums[i];
        }
        return tmp;
    }
}