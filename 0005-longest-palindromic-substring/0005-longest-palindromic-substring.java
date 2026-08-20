class Solution {
    int palindrom(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0,end=0;
        for(int i=0;i<n;i++){
            int len1=palindrom(s,i,i);
            int len2=palindrom(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start+1){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
}