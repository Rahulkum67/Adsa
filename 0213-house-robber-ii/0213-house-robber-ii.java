class Solution {
    int robhelper(int[] nums ,int st,int end){
        int n=end-st+1;
        if (n == 1) return nums[st];
        int dp[]=new int[n];
        dp[0]=nums[st];
        dp[1]=Math.max(nums[st],nums[st+1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[st+i]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int case1=robhelper(nums,0,n-2);
        int case2=robhelper(nums,1,n-1);
        return Math.max(case1,case2);
    }
}