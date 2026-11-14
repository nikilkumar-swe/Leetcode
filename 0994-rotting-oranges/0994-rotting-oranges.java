
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        // 1. Store all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Four directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 2. Start BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // Process all oranges of the current minute
            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                // Visit four neighbouring cells
                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Check valid position and fresh orange
                    if (nr >= 0 && nc >= 0 &&
                        nr < m && nc < n &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.add(new int[]{nr, nc});
                    }
                }
            }

            time++;
        }

        // 3. Return answer
        if (fresh == 0) {
            return time;
        }

        return -1;
    }
}
