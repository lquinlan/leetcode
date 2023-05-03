public class Main{
    public static void main(String[] args) {
        
    }
}
// 写复杂了
// class Solution {

//     Stack<Character> stack = new Stack<>();

//     public boolean isValid(String s) {

//         for(int i=0;i<s.length();++i){
//              if(s.charAt(i)=='a'){
//                 stack.push('a');
                
//             }else if(s.charAt(i)=='b'){
//                 if(stack.isEmpty()){
//                     return false;
//                 }
//                 if(stack.peek().equals('a')){
//                     stack.push('b');
                    
//                 }else{
//                     return false;
//                 }
//             }else if(s.charAt(i)=='c'){
//                 if(stack.isEmpty()||stack.size()<2){
//                     return false;
//                 }
//                 char tmp1=stack.pop();
//                 char tmp2=stack.pop();
//                 if(tmp1=='b'&&tmp2=='a'){
//                     continue;
                    
//                 }else{
//                     return false;
//                 }

//             }
//         }
//         if(stack.isEmpty()){
//             return true;
//         }else{
//             return false;
//         }
      

//     }
// }
// 简洁写法
// class Solution {
//     public boolean isValid(String s) {
//         StringBuilder sb = new StringBuilder();
//         var ch=s.toCharArray();
//         for(int i=0;i<ch.length;++i){
//             sb.append(ch[i]);
//             if(sb.length()>=3&&sb.substring(sb.length()-3, sb.length()).equals("abc")){
//                 sb.delete(sb.length()-3, sb.length());
//             }
//         }
//         return sb.isEmpty();

//     }
// }
// 2ms
class Solution {
    public boolean isValid(String s) {
        var chs = s.toCharArray();
        char[] stack=new char[chs.length+1];
        int ind=chs.length;
        for(var ch:chs){
            if(ch=='a'){
                stack[--ind]='a';
            }else if(ch=='b'){
                if(stack[ind]=='a'){
                    stack[--ind]='b';
                }else{
                    return false;
                }
            }else if(ch=='c'){
                if(stack[ind]=='b'&&stack[ind+1]=='a'){
                    ind+=2;
                }else{
                    return false;
                }
            }
        }
        if(ind==chs.length){
            return true;
        }else{
            return false;
        }

    }
}