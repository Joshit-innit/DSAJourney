class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder result = new StringBuilder();
        if (sum > 9 * num) {
            return "";
        }
        int nines = sum / 9;
        int lastNumber = sum % 9;
        for (int i = 0;i < nines; i++) result.append("9");
        if (lastNumber > 0) result.append(lastNumber);
        int m = num - result.length();
        for (int i = 0; i < m;i++) result.append("0");
        return result.toString();

    }
}