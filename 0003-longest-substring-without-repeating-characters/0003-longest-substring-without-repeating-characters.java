import java.util.Hashtable;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Hashtable<Character,Integer> has=new Hashtable<>();
        int left=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            while(has.containsKey(s.charAt(i))){
                has.remove(s.charAt(left));
                left++;
            }
            has.put(s.charAt(i),1);
            ans=Math.max(ans,i-left+1);
        }   
        return ans;                                
    }
}