class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int ar:arr){
            if(ar<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}