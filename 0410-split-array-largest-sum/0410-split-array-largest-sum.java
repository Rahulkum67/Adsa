class Solution {
    int split(int nums[],int part){
        int count=1;
        int sum=0;
        for(int num:nums){
            if(sum+num>part){
                count++;
                sum=0;
            }
            sum+=num;
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int max=0;
        for(int n:nums){
            sum+=n;
            max=Math.max(max,n);
        }
        int st=max;
        int end=sum;
        int ans=sum;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(split(nums,mid)<=k){
                ans=Math.min(ans,mid);
                end=mid-1;

            }else{
                st=mid+1;
            }
        }
        return ans;
    }
}