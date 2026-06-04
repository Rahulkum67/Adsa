class Solution {
    void dfs(int st,ArrayList<Integer> path,List<List<Integer>> ans,int[][] graph){
        path.add(st);
        if(st==graph.length-1){
            ans.add(new ArrayList<>(path));
        }else{
            for(int next:graph[st]){
                dfs(next,path,ans,graph);
            }
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        dfs(0,path,ans,graph);
        return ans;
    }
}