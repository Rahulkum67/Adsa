class Solution {
    static int binarysearch(int[] arr,int a){
        int n=arr.length;
        int st=0;
        int end=n-1;
        int ans=n;
        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid]>=a){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
            
        }
        return ans;
    }
    public int searchInsert(int[] nums, int target){
        int a=binarysearch(nums,target);   
        return a;

    }    
    
    
}