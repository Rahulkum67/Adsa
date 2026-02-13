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
    
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] isvisted=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }else{
                    mat[i][j]= -1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if( isvalid(nr,nc,n,m) && mat[nr][nc]== -1 ){
                    q.add(new Pair(nr,nc));
                    mat[nr][nc]=mat[cpr][cpc]+1;
                }
            }
        }
        return mat;
    }
}