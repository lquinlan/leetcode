
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {
        String s="   dsf fd gdf   dgf";
    //     tmp.trim();
    //     System.out.println(tmp);
    //    Stream.of(tmp.split("\\s+")).forEach(str->System.out.println(str.length()));
    //    s = s.trim();
       // 正则匹配连续的空白字符作为分隔符分割
       List<String> wordList = Arrays.asList(s.split(" "));
       System.out.println(wordList.toString());
       Collections.reverse(wordList);
    //    return String.join(" ", wordList);



    }
}
class Solution {
    public String reverseWords(String s) {
        // var strs=s.split(" ");
        StringBuilder sb=new StringBuilder();
        Stream.of(s.split(" ")).forEach(str->{
            if(str.length()>0){
                sb.insert(0,str+" ");
            }
        });
        // System.out.println(sb.toString());
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
        

    }
}