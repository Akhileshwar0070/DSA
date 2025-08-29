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

