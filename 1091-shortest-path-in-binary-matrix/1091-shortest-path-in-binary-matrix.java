class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }

    }
    int[] rd={-1,-1,-1,0,0,1,1,1};
    int[] cd={-1, 0, 1, -1, 1, -1, 0, 1};
    boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        if(grid[0][0] != 0  ){
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        
        count=1;
        boolean[][] isvisted=new boolean[n][n];
        isvisted[0][0]=true;
        
        while(!q.isEmpty()){
            for(int j=0;j<q.size();j++){
            Pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            if(cpr==n-1 && cpc ==n-1){
                    return count;
                }
            for(int i=0;i<8;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                
                if(isvalid(nr,nc,n,n) && grid[nr][nc]==0  && isvisted[nr][nc]==false) {
                    
                    isvisted[nr][nc]=true;
                    q.add(new Pair(nr,nc));
                    
                }
            }
            }
            count++;
        }
        return-1;
    }
}