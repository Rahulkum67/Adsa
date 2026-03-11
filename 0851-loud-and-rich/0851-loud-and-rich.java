class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] i:richer){
            adj[i[1]].add(i[0]);
        }
        int ans[]=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            dfs(i,adj,quiet,ans);
        }
        return ans;
    }
    public int dfs(int node,List<Integer>[] adj,int[] quiet,int[] ans){
        if(ans[node] != -1){
            return ans[node];
        }
        ans[node]=node;
        for(int nei : adj[node]){

            int candidate = dfs(nei, adj, quiet, ans);

            if(quiet[candidate] < quiet[ans[node]]){
                ans[node] = candidate;
            }
        }

        return ans[node];
    }
}