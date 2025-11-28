

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        
        // Step 1: Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = n - 1;
            // Step 2: Find the element just larger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the elements from i+1 to the end
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    // Utility function to print the array
    static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        System.out.println("Given Array");
        printArray(arr);
        
        Solution ob = new Solution();
        ob.nextPermutation(arr);
        
        System.out.println("Next Permutation");
        printArray(arr);
    }
}
