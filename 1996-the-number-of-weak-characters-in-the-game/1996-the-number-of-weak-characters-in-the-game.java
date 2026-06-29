class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });


        int maxDefense = Integer.MIN_VALUE;
        int n = properties.length;
        int weak = 0;
        for (int i = 0; i < n; i++) {
            if (properties[i][1] < maxDefense) {
                weak++;
            }
            else {
                maxDefense = properties[i][1];
            }
        }

        return weak;
    }
}