class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even=0;
        long odd=0;
        for(int num:nums){
            long neweven=Math.max(even,odd+num);
            long newodd=Math.max(odd,even-num);
            even=neweven;
            odd=newodd;
        }
        return even;
    }
}