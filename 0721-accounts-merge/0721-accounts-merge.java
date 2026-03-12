class Solution {

    class DSU {
        int parent[];

        DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }

        void union(int a,int b){
            parent[find(a)] = find(b);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){

                String email = accounts.get(i).get(j);

                if(!map.containsKey(email))
                    map.put(email,i);
                else
                    dsu.union(i,map.get(email));
            }
        }

        Map<Integer,TreeSet<String>> res = new HashMap<>();

        for(String email: map.keySet()){
            int parent = dsu.find(map.get(email));
            res.putIfAbsent(parent,new TreeSet<>());
            res.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int p: res.keySet()){
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(p).get(0));
            temp.addAll(res.get(p));
            ans.add(temp);
        }

        return ans;
    }
}