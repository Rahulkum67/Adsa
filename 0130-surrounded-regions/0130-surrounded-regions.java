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
    public boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    
    public void bfs(char[][] board,int st,int end,boolean[][] isvisted,int n,int m){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(st,end));
        isvisted[st][end]=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int currpairrow=curr.row;
            int currpaircol=curr.col;
            for(int i=0;i<4;i++){
                int newrow=currpairrow+rowdirection[i];
                int newcol=currpaircol+coldirection[i];
                if(isvalid(newrow,newcol,n,m) && isvisted[newrow][newcol]==false && board[newrow][newcol]=='O'){
                    isvisted[newrow][newcol]=true;
                    q.add(new Pair(newrow,newcol));
                }
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        
        boolean[][] isvisted=new boolean[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'&& isvisted[0][i]==false){
                bfs(board,0,i,isvisted,n,m);
            }
        }
        for(int i=0;i<m;i++){
            if(board[m-1][i]=='O'&& isvisted[n-1][i]==false){
                bfs(board,m-1,i,isvisted,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'&& isvisted[i][0]==false){
                bfs(board,i,0,isvisted,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][n-1]=='O'&& isvisted[i][n-1]==false){
                bfs(board,i,n-1,isvisted,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isvisted[i][j]==false && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        
    }
}