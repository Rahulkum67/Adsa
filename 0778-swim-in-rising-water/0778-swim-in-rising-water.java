class Solution {
    class Pair{
        int row ,col,dist;
        Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    int[] rd={-1,1,0,0};
    int[] cd={0,0,-1,1};
    boolean isvalid(int a,int b,int n,int m){
        return (a>=0 && b>=0 && a<n && b<m);
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(0,0,grid[0][0]));
        boolean[][] isvisted=new boolean[n][n];
        isvisted[0][0]=true;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            int cpt=curr.dist;
            if(cpr == n-1 && cpc == n-1){
                return cpt;
            }
            for(int i=0;i<4;i++){
                int newrow=cpr+rd[i];
                int newcol=cpc+cd[i];
                if(isvalid(newrow,newcol,n,n) && isvisted[newrow][newcol]==false){
                    isvisted[newrow][newcol]=true;
                    int newtime=Math.max(cpt,grid[newrow][newcol]);
                    pq.add(new Pair(newrow,newcol,newtime));
                }
            }
        }
        return -1;
    }
}