class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n==0){
            return ;

        }
        k=k%n;
        rotated(nums,0,n,k);
    }
    void rotated(int arr[],int st,int end,int k){
        int n=arr.length;
        rotatearr(arr,0,n-1);
        rotatearr(arr,0,k-1);
        rotatearr(arr,k,n-1);
    }
    void rotatearr(int[] arr ,int st ,int end){
        while(st<=end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;
            st++;
            end--;
        }
    }
}