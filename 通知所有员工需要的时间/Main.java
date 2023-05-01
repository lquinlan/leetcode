
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    // int[] vis=new int[100005];
    int[] mem = new int[100005];
    int ans = 0;

    int track(int headID, int[] manager, int[] informTime, int curind) {

        if (headID == curind) {
            // ans=Math.max(ans,tmpans);
            return informTime[headID];
        }
        if (mem[curind] != 0) {
            return mem[curind];
        }
        // int tmpans=0;
        mem[curind] = track(headID, manager, informTime, manager[curind]) + informTime[curind];
        // =tmpans;
        return mem[curind];

    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1 || n == 2) {
            return informTime[headID];
        }
        for (int i = 0; i < n; ++i) {
            if (informTime[i] == 0) {
                // vis[manager[i]]=1;
                ans = Math.max(ans, track(headID, manager, informTime, manager[i]));
            }
        }

        return ans;

    }
}