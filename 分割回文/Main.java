import java.util.ArrayList;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    List<List<String>> list = new ArrayList<List<String>>();
    List<String> tmp = new ArrayList<String>();
    String s;
    int[][] vis;

    boolean checked(int st,int en) {
        if(vis[st][en]==1){
            return true;
        }
        if(vis[st][en] == 2){
            return false;
        }
        int l = st;
        int r = en - 1;
        while (l < r) {
            if (s.charAt(r) != s.charAt(l)) {
                vis[st][en] = 2;
                return false;
            }
            ++l;
            --r;

        }
        vis[st][en] = 1;
        return true;
    }

    void dfs(int st) {
        if (s.length() == st) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = st; i < s.length(); ++i) {
           
            if (checked(st,i+1)) {
                String tmps = s.substring(st, i + 1);
                tmp.add(tmps);
                dfs(i+1);
                tmp.remove(tmp.size() - 1);

            }
        }
    }

    public List<List<String>> partition(String s) {
        this.s=s;
        vis=new int[s.length()+1][s.length()+1];

        dfs(0);

        return list;

    }
}