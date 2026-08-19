class Solution {
    int atmost(int nums[],int k){
        int l=0;
        int count=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                count++;
            }
            while(count>k){
                
                if(nums[l]%2==1){
                    count--;
                }
                l++;
            }
            ans+=(i-l+1);
            
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
}