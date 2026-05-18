class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=edges.length;
        for(int i=0;i<m;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] isvis=new boolean[n];
        q.add(source);
        isvis[source]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr==destination) return true;
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                if(isvis[nighbour]==false){
                    isvis[nighbour]=true;
                    q.add(nighbour);
                }
            }
        }
        return false;

    }
}