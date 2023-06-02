import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main{

}
class Solution {
    class node{
        int l;
        int r;
        int h;
        node(int l,int r, int h){
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {

        PriorityQueue<node> queue = new PriorityQueue<>((i,j)->j.h-i.h);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> event=new ArrayList<>();
        for(var o:buildings){
            event.add(o[0]);
            event.add(o[1]);
        }
        Collections.sort(event);
        int ind=0;
        for(var bound:event){
            while(ind<buildings.length&&buildings[ind][0]<=bound){
                queue.add(new node(buildings[ind][0], buildings[ind][1], buildings[ind][2]));
                ++ind;
            }
            while(!queue.isEmpty()&&queue.peek().r<=bound){
                queue.poll();
            }
            int maxh=queue.isEmpty()?0:queue.peek().h;
            if(result.size()==0||maxh!=result.get(result.size()-1).get(1)){
                result.add(List.of(bound,maxh));
            }
        }
        // result.add(List.of(buildings[buildings.length-1][1],0));  
        return result;

    }
}


