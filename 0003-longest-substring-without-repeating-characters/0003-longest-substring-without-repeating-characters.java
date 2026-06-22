import java.util.Hashtable;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Hashtable<Character,Integer> has=new Hashtable<>();
        int left=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            while (has.containsKey(ch)) {
                has.remove(s.charAt(left));
                left++;
            }

            has.put(ch, 1);
            ans = Math.max(ans, i - left + 1);
        }   
        return ans;                                
    }
}