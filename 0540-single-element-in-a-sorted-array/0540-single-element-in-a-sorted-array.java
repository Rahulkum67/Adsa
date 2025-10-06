class Solution {
    public int singleNonDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int count=1;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],count+1);
            }
            else{
                map.put(nums[i],count);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int ans=entry.getKey();
            int key=entry.getValue();
            if(key==1) return ans;
        }
        return -1;
    }
}