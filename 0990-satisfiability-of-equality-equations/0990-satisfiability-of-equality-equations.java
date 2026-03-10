public class DSU{
    int parent[];
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
        if(parent[x] != x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
         if(pa != pb){
            if(rank[pa] > rank[pb]){
                parent[pb]=pa;
            }else if(rank[pa] < rank[pb]){
                parent[pa]=pb;
            }else{
                parent[pb]=pa;
                rank[pa]++;
            }
         }
    }
}
class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu=new DSU(26);
        for(String e : equations){
            if(e.charAt(1) == '='){
                int a = e.charAt(0) - 'a';
                int b = e.charAt(3) - 'a';
                dsu.union(a,b);
            }
        }
        for(String e : equations){
            if(e.charAt(1) == '!'){
                int a = e.charAt(0) - 'a';
                int b = e.charAt(3) - 'a';
                if(dsu.find(a) == dsu.find(b)){
                    return false;
                }
            }
        }

        return true;
    }
}