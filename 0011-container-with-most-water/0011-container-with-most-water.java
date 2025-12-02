class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int le=n;
        int maxwater=Integer.MIN_VALUE;
        int i=0 ,j=n-1;
        while(i<=j){
            int m;
            if(height[i]<height[j]){
                m=height[i]*(j-i);
                maxwater=Math.max(maxwater,m);
                i++;
            }else{
                m=height[j]*(j-i);
                maxwater=Math.max(maxwater,m);
                j--;
            }
        }
        return maxwater;
    }
}