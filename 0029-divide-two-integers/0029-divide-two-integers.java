class Solution {
    public int divide(int dividend, int divisor) {
        int sing;
        if(dividend<0 && divisor<0){
            sing=1;
        }else if(dividend<0 && divisor>0){
            sing=-1;
        }else if(dividend>0 && divisor<0){
            sing=-1;
        }else{
            sing=1;
        }
        long d=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        long ans=d/b;
        return sing*(int)ans;
    }
}