import java.util.*;

class Solution {

    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<Pair> pq = new LinkedList<>();
        Queue<Pair> aq = new LinkedList<>();

        // Pacific borders (top row & left column)
        for (int i = 0; i < m; i++) {
            pq.offer(new Pair(i, 0));
            pacific[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Pair(0, j));
            pacific[0][j] = true;
        }

        // Atlantic borders (bottom row & right column)
        for (int i = 0; i < m; i++) {
            aq.offer(new Pair(i, n - 1));
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            aq.offer(new Pair(m - 1, j));
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pq, pacific);
        bfs(heights, aq, atlantic);

        // Result
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void bfs(int[][] heights, Queue<Pair> q, boolean[][] visited) {
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int[] d : dirs) {
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] < heights[cur.r][cur.c]) continue;

                visited[nr][nc] = true;
                q.offer(new Pair(nr, nc));
            }
        }
    }
}