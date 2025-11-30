class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        HashSet<Integer>map =new HashSet<>();
        int index=0;
        for(int num:nums){
            if(!map.contains(num)){
                map.add(num);
                nums[index]=num;
                index++;
            }
        }
        return index;
    }
}