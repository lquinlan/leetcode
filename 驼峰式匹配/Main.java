import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<Boolean>();

        for (String query : queries) {
            int l=0;
            boolean cur=true;
            for(int i = 0; i < query.length(); i++){
                if(l<pattern.length()&&pattern.charAt(l) ==query.charAt(i)){
                    ++l;
                }else if (query.charAt(i)>='A'&&query.charAt(i)<='Z') {
                    // System.out.println(query);
                    // System.out.println("i--"+i);
                    cur=false;
                    break;
                }

            }
            // System.out.println("l--"+l);
            if(cur&&l<pattern.length()){
                cur = false;
            }
            result.add(cur);
        }



        return result;
    }
}