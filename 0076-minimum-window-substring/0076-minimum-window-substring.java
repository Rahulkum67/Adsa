class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int[] freq=new int[126];
        int st=0;
        int l=0;
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }
        int count=t.length();
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(freq[c]>0){
                count--;
            }
            freq[c]--;
            while(count==0){
                char ch=s.charAt(l);
                if(i-l+1<minlen){
                    minlen=i-l+1;
                    st=l;
                }
                freq[ch]++;
                if(freq[ch]>0){
                    count++;
                }
                l++;
            }
        }
        return minlen==Integer.MAX_VALUE ?"": s.substring(st,st+minlen);
    }
}