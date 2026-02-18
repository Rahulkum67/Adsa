class Solution {
    public boolean hasAlternatingBits(int n) {
        String binarys=Integer.toBinaryString(n);
        if(binarys.length()==2){
            if(binarys.charAt(0)==binarys.charAt(0)){
                return false;
            }
        }
        else{
            for(int i=1;i<binarys.length()-1;i++){
            if(binarys.charAt(i-1)==binarys.charAt(i)  || binarys.charAt(i+1)==binarys.charAt(i)){
                return false;
            }
        }
        }
        
        
        return true;
    }
}