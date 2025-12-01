class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int n=haystack.length();
        int m=needle.length();
        while(i<=n-m){
            int j=0;
            while(j<m && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if(j==m) return i;
            i++;
        }
        return -1;
    }
}