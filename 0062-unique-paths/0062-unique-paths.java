class Solution {
    // int unique(int i,int j,int n,int m){
    //     if(i==n-1 && j==m-1){
    //         return 1;
    //     }
    //     if(i>=n || j>=m){
    //         return 0;
    //     }
    //     int rightway=unique(i,j+1,n,m);
    //     int downway=unique(i+1,j,n,m);
    //     return rightway+downway;
    // }
    int unique(int i,int j,int n,int m,Integer dp[][]){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int rightway=unique(i,j+1,n,m,dp);
        int downway=unique(i+1,j,n,m,dp);
        return dp[i][j]=rightway+downway;
    }
    public int uniquePaths(int m, int n) {
        
        Integer dp[][]=new Integer[m][n];
       int ans= unique(0,0,m,n,dp);
       return ans;
        
    }
}