class Solution {
    public void moveZeroes(int[] nums) {
      int n=nums.length;
      int i=0 ;
      while( i<nums.length&&(!(nums[i]==0))){
        i++;

      }
      int j=i+1;
      while(j<nums.length){
        if(nums[i]==nums[j]){
            j++;
        }else{
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j++;
        }
      }
        
    }
}