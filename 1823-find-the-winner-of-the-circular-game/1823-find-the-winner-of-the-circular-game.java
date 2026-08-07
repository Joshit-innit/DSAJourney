class Solution {
    public int winner(Deque<Integer> queue, int k) {
        if (queue.size() == 1) {
            return queue.pollFirst();
        }

        for (int i = 0; i < k - 1; i++) {
            queue.addLast(queue.pollFirst());
        }
        queue.pollFirst();
        return winner(queue, k);
    }
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <=n; i++) {
            queue.addLast(i);
        }
        return winner(queue, k);
    }
}