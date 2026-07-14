class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int jobs[][] = new int[n][2];
        int total = 0;

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < n; i++) {
            jobs[i][1] = Math.max(jobs[i][1], jobs[i-1][1]);
        }
        for (int target : worker) {
            int left = 0;
            int right = n - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (jobs[mid][0] <= target) {
                    index = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            total += (index == -1)?0:jobs[index][1];
        }
        return total;
    }
}