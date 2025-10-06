class Solution {
    public boolean search(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        
        while (st <= end) {
            int mid = st + (end - st) / 2;
            
            if (nums[mid] == target) return true;
            
            // Handle duplicates
            if (nums[mid] == nums[st] && nums[mid] == nums[end]) {
                st++;
                end--;
            } 
            // Left half is sorted
            else if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return false;
    }
}
