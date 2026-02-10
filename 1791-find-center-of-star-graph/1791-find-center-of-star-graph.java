class Solution {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        // Otherwise, edges[0][1] must be the center
        return edges[0][1];
        /*
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                int from=edges[i][0];
                int to=edges[i][1];
                adj.get(from).add(to);
                adj.get(to).add(from);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] isvist=new boolean[n];
        q.add(0);
        isvist[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(adj.get(curr).size()==n-1){
                return curr;
            }
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                if(isvist[nighbour]==false){
                    isvist[nighbour]= true;
                    q.add(nighbour);
                }
            }
        }
        return -1;
        */
    }
}