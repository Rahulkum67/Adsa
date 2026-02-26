class Solution {
    public boolean isBipartite(int[][] edges) {
        int V=edges.length;
        
        Queue<Integer> q=new LinkedList<>();
        char[] iscolor=new char[V];
        
        
        boolean[] isvisited=new boolean[V];
        
        for (int start = 0; start < V; start++) {
            if (isvisited[start]) continue;

            q.add(start);
            isvisited[start] = true;
            iscolor[start] = 'r';

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int i = 0; i < edges[curr].length; i++) {
                    int neighbour = edges[curr][i];

                    if (!isvisited[neighbour]) {
                        isvisited[neighbour] = true;
                        iscolor[neighbour] = (iscolor[curr] == 'r') ? 'b' : 'r';
                        q.add(neighbour);
                    } else {
                        if (iscolor[curr] == iscolor[neighbour])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}