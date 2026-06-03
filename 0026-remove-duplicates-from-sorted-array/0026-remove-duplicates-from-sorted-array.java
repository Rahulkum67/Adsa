class Solution {
    public int removeDuplicates(int[] nums) {
        // if (nums.length == 0) return 0;
        
        // int k = 1;
        
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[i - 1]) { 
        //         nums[k] = nums[i]; 
        //         k++;
        //     }
        // }
        
        // return k;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else {
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        return i+1;
    }
}
