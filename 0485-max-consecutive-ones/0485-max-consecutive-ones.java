class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxone=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) count++;
            else count=0;
            maxone=Math.max(maxone,count);
        }
        return maxone;
    }
}