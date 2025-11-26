class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++){
            if(!h.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }
}