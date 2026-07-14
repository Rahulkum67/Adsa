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
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                }
            }
        }
        if(q.isEmpty()|| q.size()==n*n) return -1;
        int dist=-1;
        int[] rd={-1,1,0,0};
        int[] cd={0,0,-1,1};
        while(!q.isEmpty()){
            int size=q.size();
            dist++;
            for(int i=0;i<size;i++){
                Pair cur=q.poll();
                int cpr=cur.row;
                int cpc=cur.col;
                for(int j=0;j<4;j++){
                    int nr=cpr+rd[j];
                    int nc=cpc+cd[j];
                    if(isvalid(nr,nc,n,n) && grid[nr][nc]==0){
                        grid[nr][nc]=1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        return dist;
    }
}