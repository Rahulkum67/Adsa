class Solution {
    boolean dayss(int[] arr,int cap,int day){
        int load=0;
        int days=1;
        for(int ar:arr){
            if(load+ar >cap){
                days++;
                load=0;
            }
            load+=ar;
        }
        return (days<=day);
    }
    public int shipWithinDays(int[] weights, int days) {
        int count=0;
        int min=0;
        for(int we:weights){
            count+=we;
            min=Math.max(min,we);
        }
        int st=min;
        int end=count;
        
        while(st<=end){
            int mid=st+(end-st)/2;
            if(dayss(weights,mid,days)){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return st;
    }
}