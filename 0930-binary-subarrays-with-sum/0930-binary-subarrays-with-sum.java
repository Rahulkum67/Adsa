class Solution {
    int atmost(int nums[],int goal){
        int n=nums.length;
        int l=0;
        if (goal < 0) {
            return 0;
        }

        int sum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>goal){
                
                sum-=nums[l];
                l++;
            }
            
            ans+=(i-l+1);
            
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
}