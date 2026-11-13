
class Solution {

    // DFS to remove all land cells connected to the boundary
    private void dfs(int row, int col, int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Stop if out of bounds or current cell is water
        if (row < 0 || col < 0 || row >= rows ||
            col >= cols || grid[row][col] == 0) {
            return;
        }

        // Mark the current land cell as visited
        grid[row][col] = 0;

        // Visit all four adjacent cells
        dfs(row - 1, col, grid); // Up
        dfs(row + 1, col, grid); // Down
        dfs(row, col - 1, grid); // Left
        dfs(row, col + 1, grid); // Right
    }

    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse left and right boundaries
        for (int row = 0; row < rows; row++) {

            dfs(row, 0, grid);
            dfs(row, cols - 1, grid);
        }

        // Traverse top and bottom boundaries
        for (int col = 0; col < cols; col++) {

            dfs(0, col, grid);
            dfs(rows - 1, col, grid);
        }

        int enclaveCount = 0;

        // Count the remaining land cells
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {
                    enclaveCount++;
                }
            }
        }

        return enclaveCount;
    }
}
