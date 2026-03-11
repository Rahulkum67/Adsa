class DSU{
    int[] parent;
    int rank[];
    DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    int find(int x){
        if(parent[x] !=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int x,int y){
        int pa=find(x);
        int pb=find(y);
        if(pa != pb){
            if(rank[pa]<rank[pb]){
                parent[pa]=pb;
            } else if(rank[pa]>rank[pb]) parent[pb]=pa;
            else {
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }
}
class Solution {
    class Pair{
        int node;
        int dist;
        int wt;
        Pair(int node,int dist,int wt){
            this.node=node;
            this.dist=dist;
            this.wt=wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        DSU dsu=new DSU(points.length);
        int n=points.length;
        int sum=0;
        ArrayList<Pair> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                int d=Math.abs(points[i][0]-points[j][0])+ Math.abs(points[i][1] - points[j][1]);
                adj.add(new Pair(i,j,d));
                
            }
        }
        Collections.sort(adj,(a,b)->a.wt-b.wt);
        
        int count=0;
        for(int i=0;i<adj.size();i++){
            Pair curr=adj.get(i);
            if(dsu.find(curr.node)  != dsu.find(curr.dist)){
                sum += curr.wt;
                dsu.union(curr.node , curr.dist);
                count++;
                if(count == n-1){
                    break;
                }
            }
        }
        return sum;
    }
}