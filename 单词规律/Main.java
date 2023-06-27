import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words =s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        Map<Character, String> map=new HashMap<Character, String>();
        Set<String> wordsSet=new HashSet<String>();
        var chs=pattern.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(map.containsKey(chs[i])){
                if(!map.get(chs[i]).equals(words[i])){
                    return false;
                }
            }else{
                if(wordsSet.add(words[i])){
                    map.put(chs[i], words[i]);
                }else{
                    return false;
                }
                
            }
        }
        return true;
    }
}