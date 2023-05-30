public class Main {

}



class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    void heapSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        // Build the max heap
        for (int i = 1; i < nums.length; i++) {
            heapInsert(nums, i);
        }

        int size = nums.length - 1;
        while (size >= 0) {
            swap(nums, 0, size--);
            heapify(nums, 0, size);
        }
    }

    void heapInsert(int[] nums, int index) {
        while (index >= 0) {
            int parentIndex = (index - 1) / 2;
            if (nums[index] > nums[parentIndex]) {
                swap(nums, parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    void heapify(int[] nums, int index, int heapSize) {
        int leftChildIndex = index * 2 + 1;
        while (leftChildIndex <= heapSize) {
            int rightChildIndex = leftChildIndex + 1;
            int largestChildIndex = (rightChildIndex <= heapSize && nums[rightChildIndex] > nums[leftChildIndex])
                    ? rightChildIndex
                    : leftChildIndex;

            int largestIndex = (nums[largestChildIndex] > nums[index]) ? largestChildIndex : index;

            if (largestIndex == index) {
                break;
            }

            swap(nums, largestIndex, index);
            index = largestIndex;
            leftChildIndex = index * 2 + 1;
        }
    }

    void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}