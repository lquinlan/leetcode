import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<queries.length;++i){
            int tmpcnt=0;
            int tmpsum=0;
            for(int j=0;j<nums.length; ++j){
                tmpsum+=nums[j];
                if(tmpsum>queries[i]){
                    // ans.add(tmpcnt);
                    break;
                }
                ++tmpcnt;

            }
            ans.add(tmpcnt);
        }
        int[] fin=new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i){
            fin[i] = ans.get(i);
        }
        return fin;

    }
}
