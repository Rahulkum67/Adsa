class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // 1. Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no such element found → array is in descending order
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 2. Find the next greater element on right side of index
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // 3. Reverse the right half to get the smallest ordering
        reverse(nums, index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
