import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            // \U0001f539 Skip duplicate elements (minor optimization)
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // \U0001f539 Update if closer
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // \U0001f539 Move pointers smartly
                if (sum < target) {
                    left++;
                    // Skip duplicates on the left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else if (sum > target) {
                    right--;
                    // Skip duplicates on the right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else {
                    // Exact match
                    return sum;
                }
            }
        }

        return closestSum;
    }
}
