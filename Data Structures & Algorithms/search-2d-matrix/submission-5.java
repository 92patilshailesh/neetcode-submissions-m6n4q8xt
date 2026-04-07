class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(log(m∗n)))
        if(matrix == null || matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top= 0, bot = rows - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][cols-1]) {
                top = row+1;
            }
            else if(target < matrix[row][0]) {
                bot = row - 1;
            }
            else {
                break;
            }
        }

        if(!(top <= bot)) {
            return false;
        }
        int row = (top + bot) /2;
         int l= 0, r = cols - 1;
         while(l<=r) {
            int m = (l+r) /2;
            if(target > matrix[row][m]) {
                l = m+1;
            }
            else if (target < matrix[row][m]){
                r = m -1;
            }
            else {
                return true;
            }
         }
        return false;
    }
}
