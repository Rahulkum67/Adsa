class Solution {
    int solve(int i,int j,int n,int m,Integer dp[][],int[][] grid){
        if(i==n-1 && j==m-1) return grid[i][j];
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(dp[i][j] != null) return dp[i][j];
        int rightway=solve(i,j+1,n,m,dp,grid);
        int downway=solve(i+1,j,n,m,dp,grid);
        return dp[i][j] = grid[i][j] + Math.min(rightway, downway);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Integer dp[][]=new Integer[n][m];
        int ans=solve(0,0,n,m,dp,grid);
        return ans;
    }
}