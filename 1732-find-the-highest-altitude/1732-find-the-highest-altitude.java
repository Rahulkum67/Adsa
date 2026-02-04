class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int highaltitude=0;
        int prefixsum=0;
        for(int i=0;i<n;i++){
            prefixsum += gain[i];
            highaltitude=Math.max(highaltitude,prefixsum);
        }
        return highaltitude;
    }
}