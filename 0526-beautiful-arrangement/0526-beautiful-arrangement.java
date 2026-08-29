class Solution {
    int result;
    public void find(boolean[] numbersAvailable, int index, int n) {
        if (index == n+1) {
            result = result + 1;
            return;
        }

        for (int i = 1; i < numbersAvailable.length; i++) {
            if (numbersAvailable[i] == false && (index % i == 0 || i % index == 0)) {
                numbersAvailable[i] = true;
                find(numbersAvailable, index + 1, n);
                numbersAvailable[i] = false;
            }
        }
    }
    public int countArrangement(int n) {
        result = 0;
        if (n == 1) {
            return 1;
        }
        int index = 1;
        boolean[] numbersAvailable = new boolean[n+1];
        find(numbersAvailable, index, n);
        return result;
    }
}