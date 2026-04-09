class Solution {
    int solve(int i,int j,int n,int m,int[][] arr,Integer[][] dp){
        if(i>=n || j>=m ||i<0 || j<0) return Integer.MAX_VALUE;
        if(i==n-1) return arr[i][j];

        
        if(dp[i][j] != null) return dp[i][j];
        int left=solve(i+1,j-1,n,m,arr,dp);
        int right=solve(i+1,j,n,m,arr,dp);
        int down=solve(i+1,j+1,n,m,arr,dp);
        return dp[i][j]=arr[i][j]+Math.min(left,Math.min(right,down));

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