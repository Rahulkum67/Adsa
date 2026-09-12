class Solution {
    public int longestConsecutive(int[] nums) {
        //Arrays.sort(nums);
        //if()
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int current=num;
                int l=1;
                while(set.contains(current+1)){
                    current++;
                    l++;
                }
                ans=Math.max(ans,l);
            }
            //ans=Math.max(ans,l)
        }
        return ans;

    }
}