class Solution {
    public int reverse(int x) {
        long ans=0;
        int sing;
        if(x<0){
            sing=-1;
        }else{
            sing=1;
        }
        x=Math.abs(x);
        while(x>0){
            int a=x%10;
            ans=ans*10+a;
            if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE){
                return 0;
            }
            x=x/10;
        }
        return (int)(sing*ans);
    }
}