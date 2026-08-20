class Solution {
    public long countSubstrings(String s, char c) {
        long sc=0;
        long co=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                sc++;
                sc+=co;
                co++;
            }
        }
        return sc;
    }
}