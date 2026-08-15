class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n=s.length();
        int prev=0;
        int count0=0;
        int count1=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                if(prev==1){
                    count0=1;
                    prev=0;
                }else{
                    count0++;
                }
            }else{
                if(prev==0){
                    count1=1;
                    prev=1;
                }else{
                    count1++;
                }
                
                ans=Math.max(ans,2*(Math.min(count1,count0)));
                
                

            }
        }
        return ans;
    }
}