class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int count=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e' || s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count++;
            }
        }
        maxi=Math.max(maxi,count);
        int i=0;
        int j=k;
        while(j<n){
            if(s.charAt(j)=='a'||s.charAt(j)=='e' || s.charAt(j)=='i'||s.charAt(j)=='o'||s.charAt(j)=='u'){
                count++;
            }
            if(s.charAt(i)=='a'||s.charAt(i)=='e' || s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count--;
            }
            
            maxi=Math.max(maxi,count);
            i++;
            j++;
        }
        return maxi;
    }
}