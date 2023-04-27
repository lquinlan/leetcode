import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}


class Solution {
    HashSet<String> words = new HashSet<String>();
    List<String> answer = new ArrayList<String>();
    List<String> ans=new ArrayList<String>();
    HashMap<Integer,List<List<String>>> answerMap = new HashMap<>();
    List<List<String>> dfs(String s,int ind){
        if(!answerMap.containsKey(ind)){
            List<List<String>> tmpans = new LinkedList<>();
            if(ind==s.length()){
                tmpans.add(new LinkedList<>());
            
            }
            for(int i=ind+1; i <= s.length(); i++){
                String tmp=s.substring(ind,i);
                if(words.contains(tmp)){
                    // answer.add(tmp);
                    // System.out.println(tmp);
                   var nextans= dfs(s,i);   
                   for(var an:nextans){
                        LinkedList<String> wo=new LinkedList<>(an);
                        wo.offerFirst(tmp);
                        tmpans.add(wo);

                   }
                    
                }
    
    
            }
            answerMap.put(ind,tmpans);

        }
        return answerMap.get(ind);

        
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        for (String word : wordDict) { 
            words.add(word);
        }
        var tmpans=dfs(s,0);
        for(var i:tmpans){
            ans.add(String.join(" ", i));
        }
        return ans;
       

    }
}