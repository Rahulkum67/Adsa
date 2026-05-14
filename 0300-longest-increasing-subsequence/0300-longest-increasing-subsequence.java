class Solution {
    public int lis(int nums[]){
        int size=0;
        for(int num : nums){
            int left =0;
            int right =size;

            while(left<right){
                int mid = left + (right-left)/2;
                //first tails[i] ele find which >=num
                if(nums[mid] >=num){
                    right = mid;
                }else{
                    left = mid+1;
                }

            }
            nums[left] = num;

            if(left == size) size++;
        }

        return size;
    }
    public int lengthOfLIS(int[] nums) {
        // int n=nums.length;
        
        // int[] dp=new int[n];
        // int maxlen=1;
        // Arrays.fill(dp,1);
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i]){
        //             dp[i]=Math.max(dp[i],dp[j]+1);
        //         }
        //     }
        //     maxlen=Math.max(maxlen,dp[i]);
        // }
        // return maxlen;
        return lis(nums);
    }
}