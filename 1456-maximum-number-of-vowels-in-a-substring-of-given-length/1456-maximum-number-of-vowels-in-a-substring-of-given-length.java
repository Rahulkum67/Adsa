class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int count=0;
        for(int i=0;i<k;i++){
            if("aeiouAEIOU".indexOf(s.charAt(i))!= -1){
                count++;
            }
        }
        int ans=count;
        for(int i=k;i<n;i++){
            if("aeiouAEIOU".indexOf(s.charAt(i))!= -1){
                count++;
            }
            if("aeiouAEIOU".indexOf(s.charAt(i-k))!= -1){
                count--;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}