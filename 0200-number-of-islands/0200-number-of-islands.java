class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    traverseIsland(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    private void traverseIsland(int row, int col, char[][] grid, boolean[][] vis) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || vis[row][col]) return;
        
        vis[row][col] = true;

        traverseIsland(row + 1, col, grid, vis);
        traverseIsland(row - 1, col, grid, vis);
        traverseIsland(row, col + 1, grid, vis);
        traverseIsland(row, col - 1, grid, vis);
    }
}