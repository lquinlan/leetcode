import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    Map<String, BiFunction<Integer,Integer,Integer>> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    Solution(){
        map.put("+",(s1,s2)->s1+s2);
        map.put("-",(s1,s2)->s2-s1);
        map.put("*",(s1,s2)->s1*s2);
        map.put("/",(s1,s2)->s2/s1);
    }
    public int evalRPN(String[] tokens) {
        for(var token:tokens){
            if(map.containsKey(token)){
                stack.push(map.get(token).apply(stack.pop(),stack.pop()));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();


    }
}