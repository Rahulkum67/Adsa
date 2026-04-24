class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] rd={-1,1,0,0};
    int[] cd={0,0,-1,1};
    public boolean isvalid(int i,int j,int n,int m){
        return (i>=0 && j>=0 && i<n && j<m);
    }
    public void bfs(int st,int end,int n,int m,boolean[][] isvisited,Queue<Pair> q,int[][] grid){
        q.add(new Pair(st,end));
        isvisited[st][end]=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,n,m)){
                    if(isvisited[nr][nc]==false && grid[nr][nc]==1){
                      isvisited[nr][nc]=true;
                      q.add(new Pair(nr,nc));
                    }
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] isvisited=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(grid[0][i]==1){
                bfs(0,i,n,m,isvisited,q,grid);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1){
                bfs(n-1,i,n,m,isvisited,q,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                bfs(i,0,n,m,isvisited,q,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1){
                bfs(i,m-1,n,m,isvisited,q,grid);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]== 1 && isvisited[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
}