class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights);
            dfs(rows -1 , c, atl, heights);
        }
        for(int r=0; r < rows; r ++) {
            dfs(r, 0, pac, heights);
            dfs(r, cols -1, atl, heights);
        }
        
        List<List<Integer>> res = new ArrayList();
        for(int r=0; r < rows; r++){
            for(int c=0; c < cols; c++) {
                if(pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for(int[] dir : directions) {
            int row = r + dir[0], col = c + dir[1];
            if(row >=0 && row < heights.length && col>=0 && col < heights[0].length &&
            !ocean[row][col] && heights[row][col] >= heights[r][c]) {
                dfs(row, col, ocean, heights);
            }
        }
    }
}
