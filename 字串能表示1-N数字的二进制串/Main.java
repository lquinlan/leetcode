import java.util.HashSet;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution1 {
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;++i){
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return  true;
    }
}

/*
 * 简单来说对于一段相同长度的二进制数如【4，7】一共又四个不同的数，又因要求是连续的字串，所以
 * 字符串的长度至少要3+4-1=6，又因为当一个长的二进制数都满足要求时，比起多的都已经包含在已有的二进制字串里面了
 * 所以我们要比较的也就没有这么多了，当给定一n时由于n的不确定所以分成两个区间
 * 1个是2^k-n,这一段区间，长度为k+1,数量n-2^k+1,总的个数k+1+n-2^k
 * 另一个是2^k-1,2^k-1，总的个数是k-1+2^k-1
 */
class Solution {
    public boolean queryString(String s, int n) {
        if(n==1){
            return s.contains(Integer.toBinaryString(n));
        }
        int k=30;
        while((1<<k)>=n){
            --k;
        }
        System.out.println(k);
        if(s.length()<(1<<(k-1))+k-1||s.length()<(n-(1<<k)+k+1)){
            return false;
        }
        return check(s,k,1<<(k-1),(1<<k)-1)&&check(s,k+1,1<<k,n);
        
        // return  true;
    }
    public boolean check(String s,int k,int start,int end){
        if(start>=end){
            return true;
        }
       int mask=(1<<k-1)-1;
       var set=new HashSet<Integer>();
       int bit=Integer.parseInt(s.substring(0,k-1),2);
       for(int i=k-1;i<s.length();++i){
            bit=((bit&mask)<<1)|(s.charAt(i)-'0');
            if(bit>=start&&bit<=end){
                set.add(bit);
            }
       }
        return set.size()==(end-start+1);
    }
}