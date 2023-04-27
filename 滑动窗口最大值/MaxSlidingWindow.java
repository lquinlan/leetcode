import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 1, -1 };
        solution.maxSlidingWindow(arr, 1);

    }
}

class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int[] answer = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        answer[j] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            System.out.println("nums[j]==" + nums[j]);

            queue.add(nums[i]);
            while (map.getOrDefault(queue.peek(), 0) != 0) {
                // queue.poll();
                map.put(queue.peek(), map.getOrDefault(queue.peek(), 0) - 1);
                queue.poll();
            }
            answer[++j] = queue.peek();
            // ++j;
        }
        return answer;

    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dp = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.offerLast(i);
        }
        int[] answer = new int[nums.length - k + 1];
        answer[0] = nums[dp.peekFirst()];
        for (int i = k; i < nums.length; ++i) {
            while (!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.offerLast(i);
            while (dp.peekFirst() <= i - k) {
                dp.pollFirst();
            }
            answer[i - k + 1] = nums[dp.peekFirst()];

        }

        return answer;
    }
}