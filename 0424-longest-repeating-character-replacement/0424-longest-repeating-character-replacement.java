class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int maxfre=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxfre=Math.max(maxfre,map.get(ch));
            int change=(i-l+1)-maxfre;
            while(change>k){
                char lch=s.charAt(l);
                map.put(lch,map.get(lch)-1);
                l++;
                change=(i-l+1)-maxfre;
            }
            ans=Math.max(ans,i-l+1);
        }
        return ans;
    }
}