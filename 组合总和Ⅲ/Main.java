import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
// import java.util.stream.IntStream;

public class Main{

}
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int tmp=0;
        for(int i=1;i<=k;++i){
            tmp+=i;
        }
        if(n<tmp){
            return list;
        }
        // if(n<IntStream.range(1, k).reduce(0,Integer::sum)){
        //     return list;
        // }
        
        dfs(k,1,n,new ArrayList<Integer>(),0);
        return list;
    }

    void dfs(int k,int ind,int n,List<Integer> ans,int sum){
        if(k==1){
            if(n-sum<=9&&n-sum>=ind){
                list.add(new ArrayList<Integer>(ans));
                list.get(list.size()-1).add(n-sum);
                return;
            }else{
                return;
            }
        }

        for(int i=ind;i<=9-k+1;i++){
            ans.add(i);
            dfs(k-1,i+1,n,ans,sum+i);
            ans.remove(ans.size()-1);
        }
    }
}