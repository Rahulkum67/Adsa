class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map=new HashSet<>();
        int l=0;
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            while(map.contains(ch)){
                map.remove(s.charAt(l));
                l++;
            }
            map.add(ch);
            ans=Math.max(ans,i-l+1);
        }
        return ans;

    }
}