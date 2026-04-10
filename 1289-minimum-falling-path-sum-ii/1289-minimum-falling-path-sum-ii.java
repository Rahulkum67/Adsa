class Solution {
    int solve(int i,int j,int n,int m,int[][] arr,Integer[][] dp){
        if(i>=n || j>=m ||i<0 || j<0) return Integer.MAX_VALUE;
        if(i==n-1) return arr[i][j];

        
        if(dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < m; k++) {
            if (k == j) continue; 
            int next = solve(i + 1, k, n, m, arr, dp);
            if (next != Integer.MAX_VALUE)
                min = Math.min(min, next);
        }

        return dp[i][j] = arr[i][j] + min;

    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        Integer dp[][]=new Integer[n][m];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,solve(0,i,n,m,matrix,dp));
        }
        return ans;
    }
}