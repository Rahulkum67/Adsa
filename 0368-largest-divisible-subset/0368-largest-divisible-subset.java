// class Solution {
//     ArrayList<Integer> temp=new ArrayList<>();
//     void solve(int st,int prv,int[] nums,List<Integer> ans){
//         if(st==nums.length) {
//             if(ans.size()>temp.size()){
//                 temp=new ArrayList<>(ans);
//             }
            
//             return;
//         }
        
//         if(prv == -1 || nums[st]%nums[prv]==0){
//             ans.add(nums[st]);
//             solve(st+1,st,nums,ans);
//             ans.remove(ans.size()-1);

//         }
//         solve(st+1,prv,nums,ans);
//     }
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         List<Integer> ans=new ArrayList<>();
//         Arrays.sort(nums);
//         solve(0,-1,nums,ans);
//         return temp;

//     }
// }

class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {

            parent[i] = i;

            for (int prev = 0; prev < i; prev++) {

                if (nums[i] % nums[prev] == 0 &&
                    dp[prev] + 1 > dp[i]) {

                    dp[i] = dp[prev] + 1;

                    parent[i] = prev;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastIndex]);

        while (parent [lastIndex] != lastIndex) {

            lastIndex = parent[lastIndex];

            ans.add(nums[lastIndex]);
        }

        Collections.reverse(ans);

        return ans;
    }
}