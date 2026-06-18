class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int end=0;
        int fast=0;
        for(int i=0;i<nums.length-1;i++){
            fast=Math.max(fast,i+nums[i]);
            if(i==end){
                jump++;
                end=fast;
            }
        }
        return jump;
    }
}