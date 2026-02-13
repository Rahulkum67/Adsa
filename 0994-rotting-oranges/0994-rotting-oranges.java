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
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int min=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean rott=false;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int cpr=curr.row;
                int cpc=curr.col;
                for(int j=0;j<4;j++){
                    int nr=cpr+rd[j];
                    int nc=cpc+cd[j];
                    if(isvalid(nr,nc,n,m) && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new Pair(nr,nc));
                        rott=true;
                    }
                }
            }
            if(rott) min++;
        }
        return fresh == 0 ? min : -1;
    }
}