class Solution {
    public int countBinarySubstrings(String s) {
        int prevsum=0;
        int currsum=1;
        int count=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currsum++;
            }else{
                count += Math.min(prevsum , currsum);
                prevsum=currsum;
                currsum=1;
            }
        }
        count += Math.min(prevsum , currsum);
        return count;
    }
}