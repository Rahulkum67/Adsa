class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        ans[0]=0;
        if(n==0) return ans;
        ans[1]=1;
        if(n==1) return ans;
        
        for(int j=2;j<=n;j++){
            int i=j;
            int bit=0;
            while(i>0){
                if((i & 1)==1){
                    bit++;
                }
                i >>=1;
            }
            ans[j]=bit;
        }
        return ans;
    }
}