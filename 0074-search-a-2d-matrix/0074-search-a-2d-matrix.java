class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int r=matrix.length;
        int c=matrix[0].length;
        int st=0;
        int end=r*c-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            int midvalue=matrix[mid/c][mid%c];
            if(midvalue==target){
                return true;
            }
            else if(midvalue<target){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}