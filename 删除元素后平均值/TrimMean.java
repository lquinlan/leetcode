import java.util.Arrays;

public class TrimMean {
    public static void main(String[] args) {

    }
}

class Solution {
    public double trimMean(int[] arr) {

        double mean = 0;
        Arrays.sort(arr);
        int s = (int) Math.floor(arr.length * 0.05);
        double sum = 0;
        for (int i = s; i < arr.length - s; i++) {
            sum += arr[i];

        }
        mean = sum / (arr.length - 2 * s);

        return mean;

    }
}