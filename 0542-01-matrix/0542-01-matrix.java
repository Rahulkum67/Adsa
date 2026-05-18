class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && y>=0 && x<n && y<m);
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[] rd={1,-1,0,0};
        int[] cd={0,0,1,-1};
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new pair(i,j));
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,n,m) && mat[nr][nc]== -1){
                    mat[nr][nc]=1+mat[cpr][cpc];
                    q.add(new pair(nr,nc));
                }
            }
        }
        return mat;
    }
}