class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] rowdirection={1,-1,0,0};
    int[] coldirection={0,0,1,-1};
    boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    void bfs(char[][] grid,boolean[][] isvisted,int currrow,int currcol,int totalrow,int totalcol){
        Queue<Pair> q=new LinkedList<>();
        Pair p=new Pair(currrow,currcol);
        q.add(new Pair(currrow,currcol));
        isvisted[currrow][currcol]=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int currpairrow=curr.row;
            int currpaircol=curr.col;
            for(int i=0;i<4;i++){
                int newrow=currpairrow + rowdirection[i];
                int newcol=currpaircol + coldirection[i];
                if(isvalid(newrow,newcol,totalrow,totalcol)&& isvisted[newrow][newcol]==false && grid[newrow][newcol]=='1'){
                    isvisted[newrow][newcol]=true;
                    q.add(new Pair(newrow,newcol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean[][] isvisted=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&& isvisted[i][j]==false){
                    count++;
                    bfs(grid,isvisted,i,j,n,m);
                }
            }
        }
        return count;
    }
}