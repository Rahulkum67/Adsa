class Solution {
    public int maxProfit(int[] prices) {
        int minpri=Integer.MAX_VALUE;
        int maxpro=0;
        for(int i=0;i<prices.length;i++){
            minpri=Math.min(minpri , prices[i]);
            maxpro=Math.max(maxpro,prices[i]-minpri);
        }
        return maxpro;
    }
}