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
    boolean isvalid(int x,int y,int n){
        return (x>=0 && x<n && y>=0 && y<n);
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
        if(q.isEmpty() || q.size() == n*n) return -1;
        int dis=-1;
        while(!q.isEmpty()){
            int size=q.size();
            dis++;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int r=curr.row;
                int c=curr.col;
                for(int j=0;j<4;j++){
                    int nr= r+rd[j];
                    int nc= c+cd[j];
                    if(isvalid(nr,nc,n) && grid[nr][nc]==0){
                        grid[nr][nc] = 1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        return dis;
    }
}