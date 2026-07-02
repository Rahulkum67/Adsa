class Solution {

    class State {
        int r, c, health;

        State(int r, int c, int health) {
            this.r = r;
            this.c = c;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        for (int[] row : best)
            Arrays.fill(row, -1);

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0)
            return false;

        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, startHealth));
        best[0][0] = startHealth;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.r == m - 1 && cur.c == n - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int newHealth = cur.health - grid.get(nr).get(nc);

                if (newHealth <= 0)
                    continue;

                if (newHealth > best[nr][nc]) {

                    best[nr][nc] = newHealth;
                    q.offer(new State(nr, nc, newHealth));
                }
            }
        }

        return false;
    }
}