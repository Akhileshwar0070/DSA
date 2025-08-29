/*
Problem Statement: Given two values M and N, which represent a matrix[M][N].We need to find the total unique
paths from the top-left cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).
*/

class Solution {

  // Recursive 
    public int uniquePaths(int m, int n) {
      return Paths(m-1,n-1);
    }
  private int Paths(int i , int j){
        if(i == 0 && j == 0) return 1 ;
        if(i < 0 || j < 0 ) return 0 ;
        
      int up = Paths(i-1,j);
      int left = Paths(i,j-1);

      return up + left;
    }
}



class Solution {
  // Dynamic Programming :- Memoization
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
       for(int[]row : dp){
        Arrays.fill(row,-1);
       }
        int ans = Paths(m-1,n-1,dp);
       return ans;
    }

    private int Paths(int i , int j, int[][]dp){
        if(i == 0 && j == 0) return 1 ;
        if(i < 0 || j < 0 ) return 0 ;
        if(dp[i][j]!=-1) return dp[i][j];
      int up = Paths(i-1,j,dp);
      int left = Paths(i,j-1,dp);

      return dp[i][j] = up + left;
    }
}
