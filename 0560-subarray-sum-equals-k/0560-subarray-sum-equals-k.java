class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        //int l=0;
        int ans=0;
        // if(nums.length==1) return k;
        // for(int i=0;i<nums.length;i++){
        //     sum+=nums[i];
        //     while(sum>=k){
        //         if(sum==k){
        //             ans++;
        //         }
        //         sum-=nums[l];
        //         l++;
        //     }
        // }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int n:nums){
            sum+=n;
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}