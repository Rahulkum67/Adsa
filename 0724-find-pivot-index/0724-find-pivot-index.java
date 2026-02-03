class Solution {
    public int pivotIndex(int[] nums) {
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
        for(int k=0;k<nums.length;k++){
            if(leftpre[k]==rightpre[k]){
                return k;
            }
        }
        return -1;

        
        

        
    }
}