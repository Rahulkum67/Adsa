class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        
        // Step 1: Calculate total sum
        for (int num : nums) {
            total += num;
        }

        // Step 2: If sum is odd → not possible
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        // Step 3: DP array
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // Step 4: Fill DP
        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[target];
    }
}