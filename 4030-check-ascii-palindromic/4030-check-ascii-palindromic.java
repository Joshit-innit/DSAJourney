class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for (int ch : s.toCharArray()) {
            String binary = Integer.toBinaryString(ch);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }

            sb.append(binary);
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}