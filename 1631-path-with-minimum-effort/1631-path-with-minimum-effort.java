class Solution {
    class Tuple{
        int row ,col,dist;
        Tuple(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    int[] rd={-1,1,0,0};
    int[] cd={0,0,-1,1};
    boolean  isvalid(int x,int y ,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b) -> a.dist - b.dist);
        int[][] distan=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distan[i], Integer.MAX_VALUE);
        }
        distan[0][0]=0;
        pq.add(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple curr=pq.poll();
            int ctr=curr.row;
            int ctc=curr.col;
            int diff=curr.dist;
            if(ctr == n-1 && ctc == m-1){
                return curr.dist;
            }
            for(int i=0;i<4;i++){
                int nrow=ctr + rd[i];
                int ncol=ctc + cd[i];
                if(isvalid(nrow,ncol,n,m)){
                    int ndiff=Math.max(Math.abs(heights[ctr][ctc] - heights[nrow][ncol]),diff);
                    if(ndiff<distan[nrow][ncol]){
                        distan[nrow][ncol]=ndiff;
                        pq.add(new Tuple(nrow,ncol,ndiff));
                    }
                }
            }
        }
        return 0;
    }
}