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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int orige=image[sr][sc];
        if(orige==color) return image;
        int[] rd={1,-1,0,0};
        int[] cd={0,0,1,-1};
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(sr,sc));
        image[sr][sc]=color;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int cpr=curr.row;
            int cpc=curr.col;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,n,m) && image[nr][nc] == orige){
                    image[nr][nc] = color;
                    q.add(new pair(nr,nc));
                }
            }
        }
        return image;
    }
}