import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        var s=solution.numberToWords(10);
        System.out.println(s);

    }
}
class Solution {
    Map<Integer, String> map1 = new HashMap<Integer, String>();
    Map<Integer, String> map2 = new HashMap<Integer, String>();
    Map<Integer, String> map3 = new HashMap<Integer, String>();
    Solution(){
        map1.put(0, "Hundred");
        map1.put(1, "Thousand");
        map1.put(2, "Million");
        map1.put(3, "Billion");
        
        map2.put(1, "One");
        map2.put(2, "Two");
        map2.put(3, "Three");
        map2.put(4, "Four");
        map2.put(5, "Five");
        map2.put(6, "Six");
        map2.put(7, "Seven");
        map2.put(8, "Eight");
        map2.put(9, "Nine");
        
        map3.put(10, "Ten");
        map3.put(11, "Eleven");
        map3.put(12, "Twelve");
        map3.put(13, "Thirteen");
        map3.put(14, "Fourteen");
        map3.put(15, "Fifteen");
        map3.put(16, "Sixteen");
        map3.put(17, "Seventeen");
        map3.put(18, "Eighteen");
        map3.put(19, "Nineteen");
        map3.put(2, "Twenty");
        map3.put(3, "Thirty");
        map3.put(4, "Forty");
        map3.put(5, "Fifty");
        map3.put(6, "Sixty");
        map3.put(7, "Seventy");
        map3.put(8, "Eighty");
        map3.put(9, "Ninety");
    }
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        var words = init(num);
        List<String> ans=new ArrayList<String>();
        for(int i=0;i<words.size();i++) {
            StringBuilder sb=new StringBuilder();
            // System.out.println(words.get(i));
            
            for(int j=0;j<words.get(i).length();j++) {
                if(words.get(i).charAt(j)=='0'){
                    continue;
                }
              if(j==0){
                    // System.out.println(Integer.valueOf(words.get(i).charAt(j)));
                    sb.insert(0,map2.get(words.get(i).charAt(j)-'0'));
                }else if(j==1){
                    int key=0;
                    if(words.get(i).charAt(j)=='1'){
                        if(words.get(i).charAt(0)!='0')
                            sb.delete(1,map2.get(words.get(i).charAt(0)-'0').length()+2);
                        key=(words.get(i).charAt(j)-'0')*10+words.get(i).charAt(0)-'0';
                    }else{
                        key=(words.get(i).charAt(j)-'0');
                    }
                    
                    sb.insert(0,map3.get(key));
                }else{
                    sb.insert(0,map1.get(0));
                    sb.insert(0," ");
                    sb.insert(0,map2.get(words.get(i).charAt(j)-'0'));
                    
                }
                if(j<words.get(i).length()-1){
                    sb.insert(0," ");
                }
            }
            // sb=sb.trim();
            if(i>0&&sb.length()>0){
                if(sb.charAt(sb.length()-1)!=' ')
                    sb.append(" ");
                sb.append(map1.get(i));
                
            }
            // var str=sb.toString().trim();
            // System.out.println(str)
            if(sb.length()>0)
            ans.add(sb.toString().trim());
        }
        Collections.reverse(ans);
        return String.join(" ",ans);
        


    }
    List<String> init(int num){
        List<String> words = new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        int i=0;
    
        while(num>0){
            sb.append(num%10);
            num/=10;
            ++i;
            if(i%3==0){
                words.add(sb.substring(i-3, sb.length()));
            }
        }
        if(i%3!=0){
            words.add(sb.substring(i-i%3, sb.length()));
        }
        // sb.reverse();
        return words;
    }
}