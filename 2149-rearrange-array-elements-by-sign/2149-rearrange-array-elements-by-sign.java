class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posit=0 , neg=1;
        int[] ans=new int[nums.length];
        for(int i=0;i<ans.length;i++){
            if(nums[i]>=0){
                ans[posit]=nums[i];
                posit=posit+2;
            }else{
                ans[neg]=nums[i];
                neg=neg+2;
            }
        }
        return ans;
    }
}