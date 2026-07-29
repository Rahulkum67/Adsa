class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int sum=0;
        int lm[]=new int[n];
        int rm[]=new int[n];
        lm[0]=arr[0];
        rm[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            lm[i]=Math.max(lm[i-1],arr[i]);
        }
        for(int k=n-2;k>=0;k--){
            rm[k]=Math.max(rm[k+1],arr[k]);
        }
        for(int i=1;i<n-1;i++){
            // int lm=-1;
            // int rm=-1;
            // for(int j=i-1;j>=0;j--){
            //     lm=Math.max(lm,arr[j]);
            // }
            // for(int k=i+1;k<n;k++){
            //     rm=Math.max(rm,arr[k]);
            // }
            if(arr[i]>lm[i] && arr[i]>rm[i]){
                continue;
            }
            int min=Math.min(lm[i],rm[i]);
            if(min<arr[i]) continue;
            sum+=min-arr[i];
        }
        return sum;
    }
}