import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.prlongln(solution.eval("1+2*3"));
        
    }
}
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> addOperators(String num, long target) {
        dfs(num, target,0);
        return res;

    }

    void dfs (String num,long target,int ind){
        if(ind==num.length()-1){
            if(eval(num)==target){
                res.add(num);
            }

            return;
        }
        dfs(num,target,ind+1);
        dfs(num.substring(0, ind+1)+'+'+num.substring(ind+1),target,ind+2);
        dfs(num.substring(0, ind+1)+'-'+num.substring(ind+1),target,ind+2);
        dfs(num.substring(0, ind+1)+'*'+num.substring(ind+1),target,ind+2);

    }
    long eval(String exp){
        Stack<Long> stack = new Stack<>();
        char presingle='+';
        long ans=0;
        long tmp=0;
        for(int i=0;i<exp.length();i++){
            if(Character.isDigit(exp.charAt(i))){
                if(exp.charAt(i)=='0'&&tmp==0&&i<exp.length()-1&&Character.isDigit(exp.charAt(i+1))){
                    return -23535;
                }
                tmp=tmp*10+exp.charAt(i)-'0';
            }
            if(!Character.isDigit(exp.charAt(i))||i==exp.length()-1){
                switch(presingle){
                    case '+':
                    stack.push(tmp);
                    break;
                    case '-':
                    stack.push(-tmp);
                    break;
                    case '*':
                    stack.push(stack.pop()*tmp);
                    break;
                }  
                presingle=exp.charAt(i);
                tmp=0; 
            }
        }
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }

}
// 简化版
class Solution1 {
    List<String> res = new ArrayList<>();
    
    public List<String> addOperators(String num, long target) {
        dfs(num, target, 0, 0, 0, "");
        return res;
    }

    void dfs(String num, long target, int start, long eval, long mult, String exp) {
        if (start == num.length()) {
            if (eval == target) {
                res.add(exp);
            }
            return;
        }
        for (int end = start + 1; end <= num.length(); end++) {
            String curStr = num.substring(start, end);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                return;
            }
            long curNum = Long.parseLong(curStr);
            if (start == 0) {
                dfs(num, target, end, curNum, curNum, curStr);
            } else {
                dfs(num, target, end, eval + curNum, curNum, exp + "+" + curStr);
                dfs(num, target, end, eval - curNum, -curNum, exp + "-" + curStr);
                dfs(num, target, end, eval - mult + mult * curNum, mult * curNum, exp + "*" + curStr);
            }
        }
    }
}