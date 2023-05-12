import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public String fractionToDecimal(int numerat, int denominat) {
        long numerator = numerat;
        long denominator = denominat;
        
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        if (Math.signum(numerator) != Math.signum(denominator)) {
            sb.append("-");
        }
        
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        
        sb.append(numerator / denominator);
        numerator %= denominator;
        
        if (numerator != 0) {
            sb.append(".");
        }
        
        Map<Long, Integer> map = new HashMap<>();
        while (numerator != 0) {
            if (map.containsKey(numerator)) {
                int position = map.get(numerator);
                sb.insert(position, "(");
                sb.append(")");
                break;
            }
            
            map.put(numerator, sb.length());
            numerator *= 10;
            sb.append(numerator / denominator);
            numerator %= denominator;
        }
        
        return sb.toString();
    }
}