class Solution {
    int count=0;
    void backtrackres(int[] nums,int i,int csum ,int target){
        if(i==nums.length){
            if(csum==target){
                count++;
            }
            return;
        }
        backtrackres(nums,i+1,csum+nums[i],target);
        backtrackres(nums,i+1,csum-nums[i],target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        backtrackres(nums,0,0,target);
        return count;
    }
}