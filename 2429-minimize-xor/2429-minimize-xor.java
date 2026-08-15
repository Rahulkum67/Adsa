class Solution {
    public int minimizeXor(int num1, int num2) {
        int count1=0;
        int count2=0;
        int temp1=num1;
        int temp2=num2;
        while(temp1>0){
            count1+= temp1&1;
            temp1 = temp1>>1;
        }
        while(temp2>0){
            count2+= temp2&1;
            temp2 = temp2>>1;
        }
        if(count1==0){
            return 0^num1;
        }
        int x=0;
        for (int i = 30; i >= 0 && count2 > 0; i--) {

            if ((num1 & (1 << i)) != 0) {
                x = x | (1 << i);
                count2--;
            }
        }

        // If more set bits are needed,
        // put them in the lowest available positions
        for (int i = 0; i <= 30 && count2 > 0; i++) {

            if ((x & (1 << i)) == 0) {
                x = x | (1 << i);
                count2--;
            }
        }

        return x;

    }
}