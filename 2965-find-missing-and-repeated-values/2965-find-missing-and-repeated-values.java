class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] ans=new int[2];
        int idx=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(set.contains(grid[i][j])){
                    ans[idx++]=grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        int d=n*n;
        for(int i=1;i<=d;i++){
            if(!set.contains(i)){
                ans[idx]=i;
            }
        }
        return ans;
    }
}