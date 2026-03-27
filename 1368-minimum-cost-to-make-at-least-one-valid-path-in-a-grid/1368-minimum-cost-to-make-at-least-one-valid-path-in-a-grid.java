class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0, 0});
        dist[0][0] = 0;

        int[][] dir = {
            {0,1},   
            {0,-1},  
            {1,0},   
            {-1,0}   
        };

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0], c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int cost = (grid[r][c] == i + 1) ? 0 : 1;

                    if (dist[r][c] + cost < dist[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + cost;

                        if (cost == 0)
                            dq.addFirst(new int[]{nr, nc});
                        else
                            dq.addLast(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist[n-1][m-1];
    }
}