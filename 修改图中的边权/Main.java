import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        @SuppressWarnings("unchecked")
        List<int[]>[] graph=new ArrayList[n];
        Arrays.setAll(graph, g->new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x].add(new int[]{y, i});
            graph[y].add(new int[]{x,i});
        }
        int[][] dist=new int[n][2];
        for (int i = 0; i < n; i++)
        if (i != source)
            dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
        Dijkstra(graph, edges, source, destination, 0, 0, dist);
        int delta=target-dist[destination][0];
        if(delta<0){
            return new int[][]{};
        }
        Dijkstra(graph, edges, source, destination, delta, 1, dist);
        if(dist[destination][1]<target){
            return new int[][]{};
        }
        for (var e : edges)
            if (e[2] == -1) 
                e[2] = 1;
        return edges;



    }
    void Dijkstra(List<int[]>[] graph,int[][] edges,int source,int destination, int delta, int k,int[][] dist){
        int n=graph.length;
       
        var vis = new boolean[n];
        // dist[source]=0;
        // vis[source]=true;
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[1]-b[1]);
        queue.offer(new int[]{source,0});
        while(!queue.isEmpty()){
            var tmp=queue.poll();
            if(tmp[0]==destination){
                return ;
            }
            if(vis[tmp[0]]){
                continue;
            }
            vis[tmp[0]]=true;
            for(var e:graph[tmp[0]]){
                int y=e[0];
                int id=e[1];
                int w=edges[id][2];
                if(w==-1)
                    w=1;
                if(k==1&&edges[id][2]==-1){
                    int nw=delta+dist[y][0]-dist[tmp[0]][1];
                    if(nw>w){
                        edges[id][2]=w=nw;
                    }
                }
                dist[y][k]=Math.min(dist[y][k],dist[tmp[0]][k]+w);
                queue.offer(new int[]{y,dist[y][k]});


            }
        }
    }
}
