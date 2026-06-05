class Solution {
    boolean ispossible(int mid,int[] arr,int m,int k){
        int flower=0;
        int bqt=0;
        for(int ar:arr){
            if(ar<=mid){
                flower++;
                if(flower==k){
                    bqt++;
                    flower=0;
                }
            }else{
                flower=0;
            }
        }
        return (bqt>=m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)k*m>n) return -1;
        int st=0;
        int end=0;
        for(int i=0;i<bloomDay.length;i++){
            st=Math.min(st,bloomDay[i]);
            end=Math.max(end,bloomDay[i]);
        }
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(ispossible(mid,bloomDay,m,k)){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
}