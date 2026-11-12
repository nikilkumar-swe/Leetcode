class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // Edge case
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    public void dfs(int[][] image, int row, int col,
                    int originalColor, int color) {

        int m = image.length;
        int n = image[0].length;

        // Boundary check
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return;
        }

        // Check original color
        if (image[row][col] != originalColor) {
            return;
        }

        // Change color (also marks visited)
        image[row][col] = color;

        // Visit four directions
        dfs(image, row - 1, col, originalColor, color); // Up
        dfs(image, row + 1, col, originalColor, color); // Down
        dfs(image, row, col - 1, originalColor, color); // Left
        dfs(image, row, col + 1, originalColor, color); // Right
    }
}