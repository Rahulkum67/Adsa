class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxwater = 0;
        while (l <= r) {
            int w = r - l;
            int h = Math.min(height[l], height[r]); 
            int currentWater = w * h;
            maxwater = Math.max(maxwater, currentWater); 
            if (height[l] < height[r]) { 
                l++;
            } else {
                r--;
            }
        }
        return maxwater;
    }
}