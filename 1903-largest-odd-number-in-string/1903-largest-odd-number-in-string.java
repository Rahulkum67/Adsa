class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        int indx=n-1;
        int i=n-1;
        while(i>=0 && (num.charAt(i)-'0')%2==0){
            indx--;
            i--;
        }
        if(indx<0){
            return "";
        }
        StringBuilder ans=new StringBuilder();
        for(int j=0;j<=indx;j++){
            ans.append(num.charAt(j));
        }
        return ans.toString();
    }
}