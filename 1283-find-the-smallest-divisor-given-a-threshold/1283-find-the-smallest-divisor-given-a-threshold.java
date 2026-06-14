class Solution {
    int sumofdivior(int arr[],int mid){
        int sum=0;
        for(int num:arr){
            sum+=Math.ceil((double)num/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length> threshold) return -1;
        int low=0;
        int high=0;
        for(int num:nums){
            high=Math.max(high,num);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sumofdivior(nums,mid)<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}