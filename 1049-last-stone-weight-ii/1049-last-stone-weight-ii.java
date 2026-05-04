class Solution {
    public int solve(int st,int sum,int arr[],Integer dp[][]){
        if(st==0){
            if(arr[st]<=sum) return arr[st];
            return 0;
        }
        if(dp[st][sum] != null) return dp[st][sum];
        int skip=solve(st-1,sum,arr,dp);
        int take=0;
        if(arr[st]<=sum){
            take=arr[st]+solve(st-1,sum-arr[st],arr,dp);
        }
        return dp[st][sum]=Math.max(skip,take);
    }
    public int lastStoneWeightII(int[] stones) {
        int total=0;
        for(int s:stones){
            total+=s;
        }
        
        int target=total/2;
        Integer dp[][]=new Integer[stones.length][target+1];
        int best=solve(stones.length-1,target,stones,dp);
        return  total - 2*best;

    }
}