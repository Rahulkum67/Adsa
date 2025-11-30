class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int need=sum%p;
        if(need==0){
            return 0;
        }
        HashMap<Integer , Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefix=0;
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%p;
            int target=(prefix-need+p)%p;
            if(map.containsKey(target)){
                ans=Math.min(ans,i-map.get(target));
            }
            map.put(prefix,i);
        }
        return ans==nums.length ? -1 :ans;
        
    }
}