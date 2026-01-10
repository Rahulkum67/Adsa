class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(first >= nums[i]){
                first=nums[i];
            }else if(second >= nums[i]){
                second=nums[i];
            }else {
                return true;
            }
        }
        return false;
    }
}