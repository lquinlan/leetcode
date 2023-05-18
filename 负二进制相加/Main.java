import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        BigInteger add1=new BigInteger("0");
        BigInteger add2=new BigInteger("0");
        BigInteger base=new BigInteger("-2");
        for(int i=0;i<arr1.length;i++){

            add1=add1.add(base.pow(arr1.length-i-1).multiply(BigInteger.valueOf(arr1[i])));
        }
        for(int i=0;i<arr2.length;i++){
            add2=add2.add(base.pow(arr2.length-i-1).multiply(BigInteger.valueOf(arr2[i])));
        }

        BigInteger sum=add1.add(add2);
  
        List<Integer> list=new ArrayList<>();
        while(sum.compareTo(BigInteger.ZERO)!=0){
            int i=sum.mod(BigInteger.valueOf(2)).intValue();
            // System.out.println("i="+i);
            list.add(i);
            sum=sum.subtract(BigInteger.valueOf(i));
            sum=sum.divide(BigInteger.valueOf(-2));
            // System.out.println("sum="+sum);
            

        }
        if(list.size()==0)
            list.add(0);
        Collections.reverse(list);
        return list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();

    }
}