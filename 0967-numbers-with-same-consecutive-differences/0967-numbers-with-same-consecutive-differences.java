class Solution {
    List<Integer> list;
    public void dfs(int countDigits, int currentNumber, int k,int  n) {
        if (countDigits == n) {
            list.add(currentNumber);
            return;
        }
        if (countDigits == 0) {
            for (int i = 1; i <=9; i++) {
                dfs(countDigits+1, i, k, n);
            }
            return;
        }
        if (currentNumber != 0) {
            int lastDigit = currentNumber % 10;
            for (int i = 0; i <= 9; i++) {
                if (Math.abs(lastDigit - i) == k) {
                    dfs(countDigits+1, currentNumber * 10 + i, k, n);
                    
                }
            }
        }


    }
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<>();
        dfs(0, 0, k, n);

        int[] result = new int[list.size()];
        int i = 0;
        for (int number : list) {
            result[i++] = number;
        }

        return result;
    }
}