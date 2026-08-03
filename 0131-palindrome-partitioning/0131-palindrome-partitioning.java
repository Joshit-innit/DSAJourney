class Solution {
    List<List<String>> result;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        result = new ArrayList<>();
        int index = 0;
        findPartitions(index, s, new ArrayList<>());
        return result;
    }
    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void findPartitions(int index,String s, List<String> list) {
        if (index == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < n; i = i+1) {
            if (isPalindrome(index, i, s)) {
                list.add(s.substring(index, i + 1));
                findPartitions(i + 1, s, list);
                list.remove(list.size() - 1);
            }
        }
     }
}