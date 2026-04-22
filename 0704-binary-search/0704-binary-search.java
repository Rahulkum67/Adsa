class Solution {
    static int binarysearch(int[] arr,int a){
        int n=arr.length;
        int st=0;
        int end=n-1;
        
        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid]==a){
                return mid;
            }
            else if(arr[mid]>a){
                end= mid-1;
            }
            if(arr[mid]<a){
                st=mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        
        int ret = new Solution().binarysearch(nums, target);
        return ret;
    }
    
}