class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count=1;
        int ans=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                count++;
            }else{
                count=1;
            }
            ans=Math.max(ans,count);
        }
        if(ans == Integer.MIN_VALUE){
            return 1;
        }
        return ans;
    }
}