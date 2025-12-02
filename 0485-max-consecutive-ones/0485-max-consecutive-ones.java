class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int numbersofone=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                numbersofone=Math.max(numbersofone,count);
            }else{
                count=0;
            }
        }
        return numbersofone;
    }
}