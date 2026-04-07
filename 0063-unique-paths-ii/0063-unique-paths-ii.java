class Solution {
    int unique(int i,int j,int n,int m,Integer dp[][],int[][] obstacleGrid){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int rightway=unique(i,j+1,n,m,dp,obstacleGrid);
        int downway=unique(i+1,j,n,m,dp,obstacleGrid);
        return dp[i][j]=rightway+downway;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
       Integer dp[][]=new Integer[m][n];
       int ans= unique(0,0,m,n,dp,obstacleGrid);
       return ans;
    }
}