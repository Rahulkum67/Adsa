class Solution {
    public int maxProfit(int[] prices) {
        int maxi=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    maxi=Math.max(maxi,prices[j]-prices[i]);
                }
            }
        }
        return maxi;
    }
}