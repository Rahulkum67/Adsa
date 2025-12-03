class Solution {
    public String longestCommonPrefix(String[] strs) {
        String firstind=strs[0];
        if(strs.length==1){
            return strs[0];
        }
        for(int i=0;i<firstind.length();i++){
            
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i)||firstind.charAt(i)!=strs[j].charAt(i){
                    if(i==0){
                        return "";
                    }else{
                        return firstind.substring(0,i);
                    }
                }
            }
        }
        return strs[0];
    }
}