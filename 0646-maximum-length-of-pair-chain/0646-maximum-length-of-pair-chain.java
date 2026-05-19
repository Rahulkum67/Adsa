class Solution {
    int solve(int st,int prev,int[][] pairs,Integer[][] dp){
        if(st==pairs.length){
            return 0;
        }
        if(dp[st][prev+1] != null) return dp[st][prev+1];
        int nottake=solve(st+1,prev,pairs,dp);
        int take=0;
        if(prev== -1 || pairs[prev][1]<pairs[st][0]){
            take=1+solve(st+1,st,pairs,dp);
        }
        return dp[st][prev+1]=Math.max(take,nottake);
    }
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        int max=0;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        // for(int i=0;i<n;i++){
        //     int count=1;
        //     for(int j=i+1;j<n;j++){
        //         if(pairs[i][1]<pairs[j][0]){
        //             count++;
        //         }else{
        //             count=1;
        //         }
        //     }
        //     max=Math.max(count,max);
        // }
        // return max;
        // int count = 1;
        // int end = pairs[0][1];

        // for (int i = 1; i < pairs.length; i++) {

        //     if (pairs[i][0] > end) {
        //         count++;
        //         end = pairs[i][1];
        //     }
        // }

        // return count;
        Integer[][] dp=new Integer[n+1][n+1];
        return solve(0,-1,pairs,dp);
    }
}