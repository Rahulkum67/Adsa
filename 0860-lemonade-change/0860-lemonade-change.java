class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        int count20=0;
        int n=bills.length;
        
        int i=0;
        while(i<n){
            if(bills[i]==5){
                count5++;
            }else if(bills[i]==10){
                if(count5<=0){
                    return false;
                }else{
                    count5--;
                    count10++;
                }
            }else{
                if(count5<=0 ){
                    return false;
                }else if(count10<=0){
                    if(count5>=3){
                        count5=count5-3;
                        count20++;
                    }else{
                        return false;
                    }
                }else{
                    count5--;
                    count10--;
                    count20++;
                }
                
            }
            i++;
        }
        return true;
    }
}