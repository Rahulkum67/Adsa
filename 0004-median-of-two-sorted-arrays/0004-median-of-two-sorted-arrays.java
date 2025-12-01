class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums1[i];
        }
        for(int i=0;i<m;i++){
            sum+=nums2[i];
        }
        double ans= (double)sum/(n+m);
        return ans;
    }
}