class Solution {
    public int closedIsland(int[][] grid) {
     
            int rows = grid.length;
            int cols = grid[0].length;
            
            for(int i = 0; i<rows; i++){
                    if(grid[i][0]==0){
                            dfs(i,0,grid);
                    }
                    if(grid[i][cols-1]==0){
                            dfs(i,cols-1,grid);
                    }
            }
            
            for(int i = 0; i<cols; i++){
                    if(grid[0][i]==0){
                            dfs(0,i,grid);
                    }
                    if(grid[rows-1][i]==0){
                            dfs(rows-1,i,grid);
                    }
            }
            
            int cnt = 0;
            
            for(int i = 0; i<rows; i++){
                    for(int j = 0; j<cols; j++){
                            if(grid[i][j]==0){
                                    cnt++;
                                    dfs(i,j,grid);
                            }
                    }
            }
            
            return cnt;
    }
        
        static void dfs(int i, int j, int grid[][]){
                
                if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1){
                        return;
                }
                
                grid[i][j]=1;
                
                dfs(i-1,j,grid);
                dfs(i+1,j,grid);
                dfs(i,j-1,grid);
                dfs(i,j+1,grid);
        }
}