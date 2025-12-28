class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Character> st=new HashMap<>();
        Map<Character,Character> ts=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(st.containsKey(ch1)){
                if(st.get(ch1) != ch2) return false ;
            }else{
                st.put(ch1 ,ch2);
            }
            if(ts.containsKey(ch2)){
                if(st.get(ch2) != ch1) return false ;
            }else{
                st.put(ch2 ,ch1);
            }
        }
        return true;
    }
}