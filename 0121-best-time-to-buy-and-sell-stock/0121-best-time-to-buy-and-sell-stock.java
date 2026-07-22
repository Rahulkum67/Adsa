class Solution {
    public int maxProfit(int[] prices) {
        int bttb=prices[0];
        int btts=0;
        for(int i=1;i<prices.length;i++){
            bttb=Math.min(bttb,prices[i]);
            btts=Math.max(btts,prices[i]-bttb);
        }
        return btts;
    }
}