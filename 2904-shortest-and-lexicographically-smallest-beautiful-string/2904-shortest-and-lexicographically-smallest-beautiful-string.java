class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        
        int count = 0;
        String result = "";
        for (int right = 0;right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                count++;
            }
            while (count > k ) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
                
            }
             if (count == k) {

                while (left < right && s.charAt(left) == '0') {
                    left++;
                }
                String sb = s.substring(left, right+1);
                
                if (result.length() == 0 || result.length() > sb.length() || (result.length() == sb.length() && sb.compareTo(result) <= 0)) {
                    result = sb;
                }
                
            }

          
        }

        return result;
    }
}