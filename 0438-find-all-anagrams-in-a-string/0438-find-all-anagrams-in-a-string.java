class Solution {
    boolean iszero(int[] freq){
        for(int x:freq){
            if(x != 0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        if(n<m) return new ArrayList<>();
        int freq[]=new int[26];
        for(int i=0;i<m;i++){
            freq[p.charAt(i)-'a']++;
        }
        for(int i=0;i<m;i++){
            freq[s.charAt(i)-'a']--;
        }

        if(iszero(freq)){
            ans.add(0);
        }
        for(int i=m;i<n;i++){
            freq[s.charAt(i)-'a']--;
            freq[s.charAt(i-m)-'a']++;

            if(iszero(freq)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
}