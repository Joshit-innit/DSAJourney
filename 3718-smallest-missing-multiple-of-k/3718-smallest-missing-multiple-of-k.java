class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] set = new boolean[(100 / k )+ 1] ;
        for (int num : nums) {
           if (num % k == 0 && (num / k )< set.length) {
                set[num / k] = true;
           }
        }

        for (int i = 1; i < set.length ; i++) {
            if (!set[i]) {
                return (i) * k;
            }
        }
        return k * set.length;
    }
}