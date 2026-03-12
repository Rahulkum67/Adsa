class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    int find(int x){
        if(parent[x] != x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    boolean union(int x,int y){
        int pa=find(x);
        int pb=find(y);
        if(pa == pb) return false;
        if(pa != pb){
            if(rank[pa] > rank[pb]){
                parent[pb]=pa;
            }else if(rank[pa] > rank[pb]) parent[pa]=pb;
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
        return true;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alis=new DSU(n);
        DSU bob=new DSU(n);
        int m=edges.length;
        int count=0;
        for(int i=0;i<m;i++){
            int typ=edges[i][0];
            if(typ==3){
                boolean a=alis.union(edges[i][1],edges[i][2]);
                boolean b=bob.union(edges[i][1],edges[i][2]);
                if(a || b){
                    count++;
                }
            }
        }
        for(int i=0;i<m;i++){
            int typ=edges[i][0];
            if(typ==1){
                
                if(alis.union(edges[i][1],edges[i][2])){
                    count++;
                }
            }
        }
        for(int i=0;i<m;i++){
            int typ=edges[i][0];
            if(typ==2){
                
                if(bob.union(edges[i][1],edges[i][2])){
                    count++;
                }
            }
        }
        int roota=alis.find(1);
        int rootb=bob.find(1);
        for(int i=2;i<=n;i++){
            if(alis.find(i) != roota || bob.find(i) != rootb){
                return -1;
            }
        }
        return m-count;
        
    }
}