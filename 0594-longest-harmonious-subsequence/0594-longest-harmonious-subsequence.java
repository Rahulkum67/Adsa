class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            while(Math.abs(nums[i]-nums[l])>1){
                l++;
            }
            if(Math.abs(nums[i]-nums[l])==1){
                ans=Math.max(ans,i-l+1);
            }
        }
        return ans;
    }
}