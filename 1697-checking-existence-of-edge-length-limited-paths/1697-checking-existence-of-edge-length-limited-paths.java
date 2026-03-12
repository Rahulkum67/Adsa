//Using BFS
// class Solution {
//     class Pair{
//         int node;
//         int dist;
//         Pair(int node,int dist){
//             this.node=node;
//             this.dist=dist;
//         }
//     }
//     public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
//         ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<edgeList.length;i++){
//             int from=edgeList[i][0];
//             int to=edgeList[i][1];
//             int wt=edgeList[i][2];
//             adj.get(from).add(new Pair(to,wt));
//             adj.get(to).add(new Pair(from,wt));
//         }
//         boolean[] ans=new boolean[queries.length];
//         for(int i=0;i<queries.length;i++){
//             int from=queries[i][0];
//             int to=queries[i][1];
//             int wt=queries[i][2];
//             Queue<Integer> q=new LinkedList<>();
//             boolean[] isvis=new boolean[n];
//             q.add(from);
//             isvis[from]=true;
//             boolean found=false;
//             while(!q.isEmpty()){
//                 int curr=q.poll();
//                 if(curr==to){
//                     found=true;
//                     break;
                    
//                 }
//                 for(int j=0;j<adj.get(curr).size();j++){
//                         Pair ni=adj.get(curr).get(j);
//                         int nighbour=ni.node;
//                         int niwt=ni.dist;
//                         if(isvis[nighbour]==false&& niwt<wt){
//                             isvis[nighbour]=true;
//                             q.add(nighbour);
//                         }
//                 }
                    
                
                
//             }
//             ans[i]=found;
//         }
//         return ans;
//     }
// }
class DSU{
    int parent[];
    int rank[];
    DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x] != x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int x,int y){
        int pa=find(x);
        int pb=find(y);
        if(pa == pb) return;
        if(pa != pb){
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            }else if(rank[pa]<rank[pb]) parent[pa]=pb;
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }
}
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);
        int q=queries.length;
        int[][] qwithindex=new int[q][4];
        for(int i=0;i<q;i++){
            qwithindex[i][0]=queries[i][0];
            qwithindex[i][1]=queries[i][1];
            qwithindex[i][2]=queries[i][2];
            qwithindex[i][3]=i;
        }
        Arrays.sort(qwithindex,(a,b) -> a[2] - b[2]);
        DSU dsu=new DSU(n);
        boolean[] ans=new boolean[q];
        int egindex=0;
        for(int i=0;i<q;i++){
            
            int limit=qwithindex[i][2];
            while(egindex < edgeList.length && limit > edgeList[egindex][2]){
                dsu.union(edgeList[egindex][0],edgeList[egindex][1]);
                egindex++;
            }
            int u=qwithindex[i][0];
            int v=qwithindex[i][1];
            int org=qwithindex[i][3];
            ans[org]= dsu.find(u)==dsu.find(v);
        }
        return ans;
    }
}