class Solution {
    public int findMaxLength(int[] nums) {
        int prefixsum=0;
        int maxlen=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                prefixsum--;
            }else{
                prefixsum++;
            }

            if(map.containsKey(prefixsum)){
                maxlen=Math.max(maxlen,i-map.get(prefixsum));
            }else{
                map.put(prefixsum,i);
            }
        }
        return maxlen;
    }
}