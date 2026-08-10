class Solution {
    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int rd[]={-1,1,0,0};
    int cd[]={0,0,-1,1};
    boolean isvalid(int x,int y,int n,int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    void bfs(int[][] arr,Queue<Pair> q,boolean[][] isvisted){
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cpr=curr.r;
            int cpc=curr.c;
            for(int i=0;i<4;i++){
                int nr=cpr+rd[i];
                int nc=cpc+cd[i];
                if(isvalid(nr,nc,arr.length,arr[0].length) && arr[nr][nc]>=arr[cpr][cpc] && isvisted[nr][nc]==false){
                    isvisted[nr][nc]=true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        int m=arr[0].length;
        boolean[][] isvistedp=new boolean[n][m];
        boolean[][] isvisteda=new boolean[n][m];
        Queue<Pair> pq=new LinkedList<>();
        Queue<Pair> aq=new LinkedList<>();
        for(int i=0;i<n;i++){
            pq.add(new Pair(i,0));
            isvistedp[i][0]=true;
        }
        for(int i=0;i<m;i++){
            pq.add(new Pair(0,i));
            isvistedp[0][i]=true;
        }
        for(int i=0;i<n;i++){
            aq.add(new Pair(i,m-1));
            isvisteda[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            aq.add(new Pair(n-1,i));
            isvisteda[n-1][i]=true;
        }
        bfs(arr,pq,isvistedp);
        bfs(arr,aq,isvisteda);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isvistedp[i][j] && isvisteda[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}