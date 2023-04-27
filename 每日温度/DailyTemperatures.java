public class DailyTemperatures {
    public static void main(String[] args) {

    }
}

// class Solution {
// public int[] dailyTemperatures(int[] temperatures) {
// int[] answer = new int[temperatures.length];
// for (int i = 0; i < temperatures.length; i++) {
// for (int j = i + 1; j < temperatures[i]; j++) {
// if (temperatures[j] > temperatures[i]) {
// answer[i] = j - i;
// break;
// }

// }
// }
// return answer;

// }
// }

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        answer[answer.length - 1] = 0;
        for (int i = answer.length - 2; i >= 0; i--) {
            if (temperatures[i] > temperatures[i + 1]) {
                if (answer[i + 1] == 0) {
                    answer[i] = 0;
                } else {
                    int j = i + 1 + answer[i + 1];
                    while (temperatures[j] <= temperatures[i]) {
                        j = j + answer[j];
                        if (answer[j] == 0)
                            break;
                    }
                    if (temperatures[j] > temperatures[i]) {
                        answer[i] = j - i;
                    } else {
                        answer[i] = 0;
                    }
                }
            } else if (temperatures[i] < temperatures[i + 1]) {
                answer[i] = 1;

            } else {
                if (answer[i + 1] == 0)
                    answer[i] = 0;
                else
                    answer[i] = answer[i + 1] + 1;
            }

        }
        return answer;

    }
}

// class Solution {
// public int[] dailyTemperatures(int[] temperatures) {
// //单调栈
// int[] answer = new int[temperatures.length];
// Stack<Integer> stack = new Stack<>();
// for (int i = 0; i < temperatures.length; i++) {
// while( !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
// int j = stack.pop();
// answer[j] = i - j;
// }
// stack.push(i);
// }
// return answer;

// }
// }