class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum=0;
        int max_sum=nums[0];
        for(int ar:nums){
            curr_sum=Math.max(ar,curr_sum+ar);
            max_sum=Math.max(max_sum,curr_sum);
        }
        return max_sum;
    }
}