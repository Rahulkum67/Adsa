class Solution {
    int solve(int i,int j,int n,int m,Integer dp[][],int[][] dungeon){
        if(i==n-1 && j==m-1) return Math.max(1,1-dungeon[i][j]);
        if(i>=n || j>= m) return Integer.MAX_VALUE;
        if(dp[i][j] != null) return dp[i][j];
        
        int downway=solve(i,j+1,n,m,dp,dungeon);
        int rightway=solve(i+1,j,n,m,dp,dungeon);
        return Math.max(1,Math.min(downway,rightway)-dungeon[i][j]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        // int n=dungeon.length;
        // int m=dungeon[0].length;
        // Integer dp[][]=new Integer[n][m];
        // int ans=solve(0,0,n,m,dp,dungeon);
        // return ans;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) java.util.Arrays.fill(row, Integer.MAX_VALUE);
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(1, need);
            }
        }
        return dp[0][0];
    }
}