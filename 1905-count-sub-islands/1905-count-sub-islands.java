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
    boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    boolean bfs(int[][] grid1, int[][] grid2,boolean[][] isvisted,int cr,int cc,int n,int m){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(cr,cc));
        isvisted[cr][cc]=true;
        boolean issubisland=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            if(grid1[cpr][cpc]==0){
                issubisland=false;
            }
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,n,m) && isvisted[nr][nc]==false && grid2[nr][nc]==1){
                    isvisted[nr][nc]=true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return issubisland;

    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;
        boolean[][] isvisted=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && isvisted[i][j]==false){
                    boolean issub=bfs(grid1,grid2,isvisted,i,j,n,m);
                    if(issub==true){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}