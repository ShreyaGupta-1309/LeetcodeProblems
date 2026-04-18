class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        for(int i = n; i > 0; i/=10){
            rev = 10 * rev + i % 10;
        }
        return Math.abs(rev-n);
    }
}