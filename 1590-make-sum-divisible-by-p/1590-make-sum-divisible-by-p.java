class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int need=(int)(sum%p);
        if(need==0){
            return 0;
        }
        HashMap<Integer , Integer> map=new HashMap<>();
        map.put(0,-1);
        long prefix=0;
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%p;
            int target=(int)((prefix-need+p)%p);
            if(map.containsKey(target)){
                ans=Math.min(ans,i-map.get(target));
            }
            map.put((int)prefix,i);
        }
        return ans==nums.length ? -1 :ans;
        
    }
}