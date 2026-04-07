class Solution {
    int solve(int i,int j,int n,Integer dp[][],List<List<Integer>> triangle){
        if(i==n-1 ) return triangle.get(i).get(j);
        
        if(dp[i][j] != null) return dp[i][j];
        int down=triangle.get(i).get(j) + solve(i+1,j,n,dp,triangle);
        int diag=triangle.get(i).get(j) + solve(i+1,j+1,n,dp,triangle);
        return dp[i][j]=Math.min(down,diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        
        Integer dp[][]=new Integer[n][n];
        int ans=solve(0,0,triangle.size(),dp,triangle);
        return ans;
    }
}