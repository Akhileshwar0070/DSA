/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

*/
import java.util.*;

class Solution {

    // Dynamic Programming :- Memoization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return paths(m - 1, n - 1, obstacleGrid, dp);
    }

    // Recursive + Memoization
    private int paths(int i, int j, int[][] obstacleGrid, int[][] dp) {
        // If there's an obstacle, no path possible
        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;

        // Base case: reached start cell
        if (i == 0 && j == 0) return 1;

        // Out of bounds
        if (i < 0 || j < 0) return 0;

        // Already computed
        if (dp[i][j] != -1) return dp[i][j];

        int up = paths(i - 1, j, obstacleGrid, dp);
        int left = paths(i, j - 1, obstacleGrid, dp);

        return dp[i][j] = up + left;
    }

    // Bottom-Up Tabulation
    public int pathTabulation(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int MOD = 1000000007; // optional if constraints require modulo

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If obstacle → no path
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } 
                // Starting cell
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } 
                // Transition from top or left
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = (up + left) % MOD;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
