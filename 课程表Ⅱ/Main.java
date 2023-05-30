import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg=new int[numCourses];
        List<List<Integer>> map=new ArrayList<List<Integer>>();
        int[] ans=new int[numCourses];
        Deque<Integer> deque=new ArrayDeque<Integer>();
        for(int i=0; i<numCourses; i++){
            map.add(new ArrayList<Integer>() );
        }
        for(var i:prerequisites){
            map.get(i[1]).add(i[0]);
            indeg[i[0]]++;

        }
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                deque.add(i);
            }

        }
        int ind=0;
        while(!deque.isEmpty()){
            int tmp=deque.poll();
            ans[ind++]=tmp;
            for(int i=0;i<map.get(tmp).size();++i){
                indeg[map.get(tmp).get(i)]--;
                if(indeg[map.get(tmp).get(i)]==0){
                    deque.add(map.get(tmp).get(i));
                }
            }
        }
        return ind==numCourses?ans:new int[0];

    }
}