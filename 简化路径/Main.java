import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String simplifyPath(String path) {
        // path = path.replaceAll("/+", "/");
        // path = path.replaceAll("/$","");
        // path = path.replaceAll("^/","");
        // path = init(path);
        // System.out.println(path);
        String[] parts = path.split("/");
        Deque<String> result = new ArrayDeque<String>();
        for(var i:parts){
            // System.out.println(i);
            if(i.equals("..")){
                for(int j=0;j<1&&!result.isEmpty();j++){
                    result.pollLast();
                }
            }else if(!i.equals(".")&&i.length()>0){
                result.offerLast(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(!result.isEmpty()){
            sb.append("/");
            sb.append(result.pollFirst());
        }
        if(sb.length()==0){
            sb.append("/");
        }
        return sb.toString();

    }

}