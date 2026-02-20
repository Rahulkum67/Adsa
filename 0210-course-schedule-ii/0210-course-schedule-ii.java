import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            
            int from=prerequisites[i][0];
            int to=prerequisites[i][1];
            adj.get(to).add(from);
            indegree[from]++;
            
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] isvisted=new boolean[prerequisites.length]; 
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            
                ans[count++]=curr;
               
          

            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                indegree[nighbour]--;
                if(indegree[nighbour]==0){
                    q.add(nighbour);
                }
            }
        }
        if(count == numCourses){
            return ans;
        }
        return new int[0];
    }
}