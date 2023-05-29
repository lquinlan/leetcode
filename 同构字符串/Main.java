import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main{

}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<Character,Character>();
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); i++){
            if(!set.contains(t.charAt(i))){
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(t.charAt(i));
                }else{
                    return false;
                }

            }else{
                if(!map.containsKey(s.charAt(i))||map.get(s.charAt(i))!=t.charAt(i)){
                    // map.put(s.charAt(i), t.charAt(i));
                    // set.add(t.charAt(i));
                    return false;
                }

            }
           
        }
        return true;

        // return get(s).equals(get(t));

    }
}
