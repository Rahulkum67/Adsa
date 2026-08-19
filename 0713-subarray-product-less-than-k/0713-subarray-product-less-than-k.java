class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int l=0;
        int ans=0;
        if(nums.length==1){
            if(nums[0]>=k){
                return 0;
            }else{
                return 1;
            }
        }
        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            while(prod>=k){
                prod/=nums[l];
                l++;
            }
            ans+=(i-l+1);
        }
        return ans;
    }
}