class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor1=0;
        for(int i=0;i<nums.length;i++){
            xor1=xor1^nums[i];
        }
        return xor1;
    }
}