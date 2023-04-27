public class GetPermutation {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.getPermutation(3, 3);

    }
}

class Solution {
    char[] tmp;
    short[] vis = new short[10];
    int tmpk = 0;
    int k = 0;
    int n;
    StringBuilder sb = new StringBuilder();

    void dfs(int curk) {
        if (tmpk == k) {

            return;
        }
        if (curk >= n) {
            ++tmpk;
            System.out.println("tmpk==" + tmpk);
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (vis[i] == 0 && tmpk < k) {
                vis[i] = 1;
                char a = (char) (i + '0');
                tmp[curk] = a;
                // System.out.println(tmp[curk]);
                dfs(curk + 1);
                vis[i] = 0;
            }
        }

    }

    public String getPermutation(int n, int k) {
        this.k = k;
        this.n = n;
        tmp = new char[n];
        dfs(0);
        for (var i : tmp) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        return sb.toString();

    }
}