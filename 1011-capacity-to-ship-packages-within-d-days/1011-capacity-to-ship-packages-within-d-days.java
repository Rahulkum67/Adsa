// class Solution {
//     public int dayss(int[] weights ,int capa){
//         int day = 1;
//         int load = 0;
//         for(int wt : weights){
//             if(load+wt>capa){
//                 day++;
//                 load = 0;
//             }
//             load = load+wt;
//         }
//         return day;
//     }
//     public int shipWithinDays(int[] weights, int days) {
       
//        int count=0;
//        int min =0;
//        for(int i=0;i<weights.length;i++){
//             count=count+weights[i];
//             min=Math.max(min,weights[i]);
//         }
//        int ans=count;
//        int st=min , end=count;
//        while(st<=end){
//         int mid=st+(end-st)/2;
//         if(dayss(weights,mid)<=days){
//             ans=Math.min(ans,mid);
//             end=mid-1;
//         }else{
//             st=mid+1;
//         }
//        } 
//        return ans;
//     }

// }
class Solution {
    int dayss(int[] arr,int cap){
        int day=1;
        int load=0;
        for(int ar:arr){
            if(load+ar > cap){
                day++;
                load=0;
            }
            load+=ar;
            
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int count=0;
        int max=0;
        for(int i:weights){
            count+=i;
            max=Math.max(max,i);
        }
        int ans=count;
        int st=max;
        int end=count;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(dayss(weights,mid)<=days){
                ans=Math.min(ans,mid);
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
}
