class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count=1;
        int ans=1;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                count++;
            }else{
                count=1;
            }
            ans=Math.max(ans,count);
        }
        
        return ans;
    }
}