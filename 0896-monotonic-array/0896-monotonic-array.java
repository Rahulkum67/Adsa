class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc=true;
        boolean dec=true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                inc=false;
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                dec=false;
            }
        }
        if(inc==true || dec==true){
            return true;
        }
        return false;
    }
}