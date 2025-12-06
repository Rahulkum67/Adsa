class Solution {
    public int reverse(int x) {
        int sing;
        if(x>0){
            sing=1;
        }else{
            sing=-1;
        }
        long ans=0;
        int n=Math.abs(x);
        
        while(n>0){
            ans=(ans*10)+n%10;
            n=n/10;
        }
        if(ans>Integer.MAX_VALUE){
            return 0;
        }
        return (sing)*(int)ans;
    }
}