class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int n=x;
        int an=0;
        
        while(n>0){
            an=(an*10)+(n%10);
            n=n/10;
        }
        return an==x;
        
    }
}