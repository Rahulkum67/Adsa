class Solution {
    boolean canfinish(int[] arr,int h,int k){
        int hour=0;
        for(int a:arr){
            hour+=(a+k-1)/k;
            if(hour>h) return false;

        }
        return hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=0;
        for(int pi:piles){
            high=Math.max(high,pi);
        }
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canfinish(piles,h,mid)){
                
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}