class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // HashSet<Integer> set=new HashSet<>();
        // int sum=0;
        // int ans=0;
        // int temp=0;
        // for(int i=0;i<k;i++){
        //     if(!set.contains(nums[i])){
        //         temp+=nums[i];
        //     }
        //     sum+=nums[i];
        //     set.add(nums[i]);
        // }
        // if(set.size()==k) ans=temp;
        // for(int i=k;i<nums.length;i++){
        //     set.remove(nums[i-k]);
        //     sum-=nums[i-k];
        //     if(!set.contains(nums[i])){
                
        //         sum+=nums[i];
        //     }
        //     set.add(nums[i]);
        //     if(set.size()==k) ans=Math.max(ans,sum);
            
        // }
        HashMap<Integer,Integer> map=new HashMap<>();
        long ans=0;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i>=k){
                int lnum=nums[i-k];
                sum-=lnum;
                map.put(lnum,map.get(lnum)-1);
                if(map.get(lnum)==0){
                    map.remove(lnum);
                }
            }
            if(i>=k-1 && map.size()==k){
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }
}