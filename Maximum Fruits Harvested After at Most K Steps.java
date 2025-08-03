class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        int [] PrefixSum = new int[n];
        int [] pos = new int [n];

        for(int i = 0; i < n ; i++){
            pos[i] = fruits[i][0];

            PrefixSum[i] = fruits[i][1] + (i > 0 ? PrefixSum[i-1] : 0);
        }

        int maxFruits = 0 ;
        for(int d = 0; d <= k/2; d++){
            // case - moved d steps to the left
            int remain = k-2*d;
            int i = startPos - d;
            int j = startPos + remain;



            int left = lowerBound(pos,i);
            int right = upperBound(pos,j) - 1;

            if(left <= right){
                int total = PrefixSum[right] - (left > 0 ? PrefixSum[left - 1] : 0);
                maxFruits = Math.max(maxFruits,total);
            }

            i = startPos - remain;
            j = startPos + d ;


             left = lowerBound(pos,i);
             right = upperBound(pos,j) - 1;

             if(left <= right){
                int total = PrefixSum[right] - (left > 0 ? PrefixSum[left - 1] : 0);
                maxFruits = Math.max(maxFruits,total);
            }
        }

        return maxFruits ;
    }

      public  int lowerBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length; // one past the last index

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // returns index of first element >= x
    }

     public  int upperBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length; // one past the last index

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // returns index of first element > x
    }
}
