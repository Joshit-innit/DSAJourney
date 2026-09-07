class Solution {
    public int firstUniqChar(String s) {
        int set[] = new int[27];
        int i = 0;
        for (char ch : s.toCharArray()) {
            int index = 'z' - ch;
             if (set[index] > 0) {
                set[index] = -1;
            } else if (set[index] == 0) {
                set[index] = i + 1;
            }

            i++;
        }

        int answer = Integer.MAX_VALUE;
        for (int num : set) {
            if (num > 0) {
                answer = Math.min(answer, num);

            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer - 1;
    }
}