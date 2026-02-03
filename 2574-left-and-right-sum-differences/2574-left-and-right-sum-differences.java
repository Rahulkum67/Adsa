class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftpre[]=new int[nums.length];
        int rightpre[]=new int[nums.length];
        int i=1;
        leftpre[0]=nums[0];
        rightpre[nums.length-1]=nums[nums.length-1];
        int j=nums.length-2;
        while(i <nums.length && j>=0){
            leftpre[i]=leftpre[i-1]+nums[i];
            rightpre[j]=rightpre[j+1]+nums[j];
            i++;
            j--;
            
        }
        int[] ans=new int[nums.length];
        for(int k=0;k<nums.length;k++){
            ans[k]=Math.abs(leftpre[k]-rightpre[k]);
        }
        return ans;
    }
}