class Solution {
    public int maxProfit(int[] prices) {
        int bttb=Integer.MAX_VALUE;
        int btts=0;
        for(int i=0;i<prices.length;i++){
            bttb=Math.min(bttb,prices[i]);
            btts=Math.max(btts,prices[i]-bttb);
        }
        return btts;
    }
}