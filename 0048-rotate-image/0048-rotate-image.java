class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2;j++){
                int temp=arr[n-1-j][i];
                arr[n-1-j][i]=arr[n-1-i][n-j-1];
                arr[n-1-i][n-j-1]=arr[j][n-1-i];
                arr[j][n-1-i]=arr[i][j];
                arr[i][j]=temp;
            }
        }
    }
}