class Solution {
    // int solve(int[] nums,int st,int p){
    //     if(st==nums.length){
    //         return 0;
    //     }
    //     int nottake=solve(nums,st+1,p);
    //     int take=0;
    //     if(p == -1 || nums[st]>nums[p]){
    //         take=1+solve(nums,st+1,st);
    //     }
    //     return Math.max(nottake,take);
    // }
    // int solvee(int[] nums,int st,int p,int l,int count){
    //     if(l==0) return 1;
    //     if(st == nums.length){
    //         return 0;
    //     }
        

    //     int nottake=solvee(nums,st+1,p,l,count);
    //     int take=0;
    //     if(p == -1 || nums[st]>nums[p]){
    //         take=1+solvee(nums,st+1,st,l-1,count);
    //     }
        
    //     return take+nottake;
        
    // }
    public int findNumberOfLIS(int[] a) {
        // int l=solve(nums,0,-1);
        // int count=0;
        // return solvee(nums,0,-1,l,count);
        int n = a.length;
        int[] len = new int[n], cnt = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    if (len[j] + 1 > len[i]) { len[i] = len[j] + 1; cnt[i] = cnt[j]; }
                    else if (len[j] + 1 == len[i]) cnt[i] += cnt[j];
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) if (len[i] == maxLen) total += cnt[i];
        return total;
    }
}