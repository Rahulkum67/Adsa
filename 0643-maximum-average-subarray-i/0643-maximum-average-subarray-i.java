class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        double m=Double.NEGATIVE_INFINITY;
        
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        double de=(double)sum/k;
        m=Math.max(de,m);
        
        int i=0 ,j=k;
        while(j<n){
           
           sum=sum+nums[j]-nums[i];
           de=(double)sum/k;
           m=Math.max(de,m);
           i++;
           j++;
           
           
        }
        return m ;
    }
}