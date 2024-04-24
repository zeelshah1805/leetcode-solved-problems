public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int bitsToReverse = 32; // Since we're reversing 32 bits (for a 32-bit integer)
        
        for (int i = 0; i < bitsToReverse; i++) {
            // Get the least significant bit of n
            int lsb = n & 1;
            // Add the bit to the result (after shifting result to the left)
            result = (result << 1) | lsb;
            // Right shift n to process the next bit
            n >>>= 1;
        }
        
        return result;
    }
}
