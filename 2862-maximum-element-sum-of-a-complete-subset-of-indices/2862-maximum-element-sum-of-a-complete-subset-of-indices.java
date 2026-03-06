class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;

        for(int k = 1; k <= n; k++){
            long sum = 0;

            for(int x = 1; k * x * x <= n; x++){
                sum += nums.get(k * x * x - 1);
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}