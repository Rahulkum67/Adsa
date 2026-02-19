class Solution {
    class Pair{
        int row;
        int col;
        int parrow;
        int parcol;
        Pair(int row,int col,int parrow,int parcol){
            this.row=row;
            this.col=col;
            this.parrow=parrow;
            this.parcol=parcol;
        }
    }
    int[] rd={-1,1,0,0};
    int[] cd={0,0,-1,1};
    boolean isvalid(int x,int y,int n, int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    boolean bfs(char[][] grid,boolean[][] isvisted,int cr,int cc,int n,int m){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(cr,cc,cr,cc));
        isvisted[cr][cc]=true;
        char ch=grid[cr][cc];
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,n,m) && grid[nr][nc]==ch){
                   if(isvisted[nr][nc]==false){
                    isvisted[nr][nc]=true;
                    q.add(new Pair(nr,nc,cpr,cpc));
                    }else if(!(nr==curr.parrow && nc==curr.parcol)){
                    return true;
                    }
                }
            }
        }
        return false;

    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] isvisted=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isvisted[i][j]==false){
                     if(bfs(grid,isvisted,i,j,n,m)){
                        return true;
                     }
                }
            }
        }
        return false;
    }
}