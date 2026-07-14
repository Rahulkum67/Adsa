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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int rd[]={-1,1,0,0};
        int cd[]={0,0,-1,1};
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int cpr=cur.row;
            int cpc=cur.col;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,n,m) && mat[nr][nc]==-1){
                    mat[nr][nc]=mat[cpr][cpc]+1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return mat;
    }
}