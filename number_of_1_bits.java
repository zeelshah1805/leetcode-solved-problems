class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; // Unsigned right shift to handle negative numbers correctly
        }
        return count;
    }
}
