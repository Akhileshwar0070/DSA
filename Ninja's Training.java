// Ninja's Training 
// Topic :- Dynamic Programming 


/*
Problem Statement: A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. 
There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.
We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.
*/



// with Recursion 
/* int N = task.length;
int result = MaxPoint(N-1, 3, task); */

public int MaxPoint(int days, int lastTask, int[][] task) {
    if (days == 0) {
        int maxi = 0;
        for (int i = 0; i < 3; i++) {  // 3 tasks
            if (i != lastTask) {
                maxi = Math.max(maxi, task[0][i]);
            }
        }
        return maxi;
    }

    int maxi = 0;
    for (int j = 0; j < 3; j++) {  // 3 tasks
        if (j != lastTask) {
            int points = task[days][j] + MaxPoint(days - 1, j, task);
            maxi = Math.max(maxi, points);
        }
    }
    return maxi;
}

// Dp :- Solutions

import java.util.*;

public class Solution {

    public static int ninjaTraining(int n, int[][] points) {
        
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxPoint(n - 1, 3, points, dp);
    }

    private static int maxPoint(int day, int lastTask, int[][] points, int[][] dp) {
        
        if (dp[day][lastTask] != -1) return dp[day][lastTask];

        
        if (day == 0) {
            int best = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    best = Math.max(best, points[0][task]);
                }
            }
            return dp[day][lastTask] = best;
        }

        
        int best = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int score = points[day][task] + maxPoint(day - 1, task, points, dp);
                best = Math.max(best, score);
            }
        }

        return dp[day][lastTask] = best;
    }
}


