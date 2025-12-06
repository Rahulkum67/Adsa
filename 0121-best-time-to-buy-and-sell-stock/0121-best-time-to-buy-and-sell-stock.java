class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int mini=prices[0];
        int maxprof=0;
        for(int i=0;i<n;i++){
            int cost=prices[i]-mini;
            maxprof=Math.max(maxprof,cost);
            mini=Math.min(mini,prices[i]);
        }
        return maxprof;
    }
}