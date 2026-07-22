class Solution {
    void swap(int nums[],int n,int m){
        int temp=nums[n];
        nums[n]=nums[m];
        nums[m]=temp;
    }
    void reversearray(int nums[],int i,int j){
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reversearray(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[idx]){
                swap(nums,i,idx);
                break;
            }
        }
        reversearray(nums,idx+1,n-1);
       
    }
}