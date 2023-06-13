import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
// import java.util.function.BinaryOperator;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    Map<Character,BiFunction<Integer,Integer,Integer>> map = new HashMap<>();
    Solution(){
        map.put('+',(a,b)->a+b);
        map.put('-',(a,b)->a-b);
        map.put('*',(a,b)->a*b);
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<expression.length(); i++) {
            var op=expression.charAt(i);
            if(op=='+'||op=='-'||op=='*') {
                var r1=diffWaysToCompute(expression.substring(0, i));
                var r2=diffWaysToCompute(expression.substring(i+1));
                for(var j:r1){
                    for(var k:r2){
                        result.add(map.get(op).apply(j, k));
                    }
                }
            }

        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }
        return result;

    }
}