class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && y>=0 && x<n && y<m);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        grid[0][0]=1;
        int count=1;
        
        int[] rd = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cd = {-1, 0, 1, -1, 1, -1, 0, 1};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int cpr=curr.row;
                int cpc=curr.col;
                if(cpr==n-1 && cpc ==n-1){
                    return count;
                }
                for(int j=0;j<8;j++){
                    int nr=cpr+rd[j];
                    int nc=cpc+cd[j];
                    if(isvalid(nr,nc,n,n) && grid[nr][nc]==0){
                        grid[nr][nc]=1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}