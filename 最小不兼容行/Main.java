public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int s=solution.minimumIncompatibility(new int[] { 1,2,3 }, 1);
        System.out.println(s);

    }
}

class Solution {
    int[] map;
    int ans=Integer.MAX_VALUE;
    public int minimumIncompatibility(int[] nums, int k) {
        if(nums.length==k){
            return 0;
        }
        map=new int[nums.length+1];
        for(var i:nums) {
            map[i]++;
        }
        int t=nums.length/k;
        dfs(0,0,0,0,k,-1,t);

        return ans==Integer.MAX_VALUE?-1:ans;
      
    }

    void dfs(int ind, int flag, int sum, int tmpk, int k, int last, int t) {
        if (sum >= ans) {
            return;
        }
        if (tmpk >= k) {
            // System.out.println("fd");
            ans = Math.min(sum, ans);
            return;
        }
        if (flag % t == 0) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] != 0) {
                    map[i]--;
                    dfs(i + 1, flag + 1, sum, tmpk, k, i, t);
                    map[i]++;
                }
            }
            // if()
        } else {
            for (int i = ind; i < map.length; i++) {
                if (map[i] != 0) {
                    map[i]--;
                    if ((flag + 1) % t == 0) {

                        dfs(i + 1, flag + 1, sum + (i - last), tmpk + 1, k, i, t);
                    } else {
                        dfs(i + 1, flag + 1, sum, tmpk, k, last, t);
                    }

                    map[i]++;
                }
            }
        }
    }
}