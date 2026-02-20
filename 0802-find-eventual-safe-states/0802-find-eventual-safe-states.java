class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        int n=graph.length;
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            indegree[i]=graph[i].length;
            for(int j=0;j<graph[i].length;j++){
                int to=graph[i][j];
                adj.get(to).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        boolean[] safe=new boolean[n];
        while(!q.isEmpty()){
            int curr=q.poll();
            safe[curr]=true;
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                indegree[nighbour]--;
                if(indegree[nighbour]==0){
                    q.add(nighbour);
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]==true){
                ans.add(i);
            }
        }
        return ans;
    }
}