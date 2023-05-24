import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges==null||edges.length==0){
            return 1;
        }
        if(target==1){
            return 0.0;
        }
        // double ans[] = new double[n + 1];
        int vis[] = new int[n + 1];
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++)
            map.add(new ArrayList<>());
        for (var i : edges) {
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }

        Queue<double[]> q = new LinkedList<>();
        q.add(new double[] { 1, 1 });
        // ans[1] = 1;
        vis[1] = 1;
        int ind = 0;
        
        while (!q.isEmpty()&&ind<t) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                double[] tmp = q.poll();
              
                int N = map.get((int) tmp[0]).size();
               
                int tN = 0;
                for (int j = 0; j < N; ++j) {
               
                    if (vis[map.get((int) tmp[0]).get(j)] == 0) {
                        ++tN;
                    }
                }
                if(tN == 0&&target==(int)tmp[0]) {
                    return tmp[1];
                }
                // if(tN>0&&(int)tmp[0]==target&&ind!=t){
                //     ans[(int)tmp[0]]=0;
                // }
                // if(ind>t){
                //     ans[(int)tmp[0]]=0;
                // }
                //  System.out.println("tN=="+tN);
                for (int j = 0; j < N; ++j) {
                    if (vis[map.get((int) tmp[0]).get(j)] == 0) {
                        if(ind==t-1&&map.get((int) tmp[0]).get(j)==target){
                            //  ans[map.get((int) tmp[0]).get(j)] = tmp[1] * (1.0 / tN);
                            // System.out.println( map.get((int)tmp[0]).get(j));
                            // System.out.println( ans[map.get((int)tmp[0]).get(j)]);
                            return tmp[1] * (1.0 / tN);
                        }
                           
                        q.add(new double[] { map.get((int) tmp[0]).get(j), tmp[1] * (1.0 / tN) });
                        vis[map.get((int) tmp[0]).get(j)]=1;
                        

                    }

                }
            }
            ++ind;
        }

        return 0;

    }
}