class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int l=0;
        int max=0;
        int ans=0;
        for(int r=0;r<s.length();r++){
            count[s.charAt(r)-'A']++;
            max=Math.max(max,count[s.charAt(r)-'A']);
            while(r-l+1-max > k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}