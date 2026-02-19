class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            
            int from=prerequisites[i][0];
            int to=prerequisites[i][1];
            adj.get(from).add(to);
            indegree[to]++;
            
        }
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            numCourses--;
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                indegree[nighbour]--;
                if(indegree[nighbour]==0){
                    q.add(nighbour);
                }
            }
        }
        if(numCourses==0){
            return true;
        }
        return false;
    }
}