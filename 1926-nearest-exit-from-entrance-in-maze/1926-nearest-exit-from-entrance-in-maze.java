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
        return (x >= 0 && x<n && y>=0 && y<m);
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int ans=0;
        int n=maze.length;
        int m=maze[0].length;
        boolean[][] isvisit=new boolean[maze.length][maze[0].length];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(entrance[0],entrance[1]));
        isvisit[entrance[0]][entrance[1]]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int cur=curr.row;
                int cuc=curr.col;
                if((cur==0 || cur==n-1 || cuc ==0 || cuc==m-1)&& !(cur==entrance[0] && cuc==entrance[1])){
                    return ans;
                }
                for(int j=0;j<4;j++){
                    int newrow=cur+rd[j];
                    int newcol=cuc+cd[j];
                    if(isvalid(newrow,newcol,n,m) && !isvisit[newrow][newcol] && maze[newrow][newcol]=='.'){
                        isvisit[newrow][newcol]=true;
                        q.add(new Pair(newrow,newcol));
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}