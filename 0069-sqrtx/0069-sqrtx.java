class Solution {
    public int mySqrt(int x) {
        if(x < 2)
           return x;
        int start =0, end = x;
        while (start <= end){
            int mid = start +(end - start) / 2;
            long midSquared = (long) mid* mid;
            if(midSquared == x)
               return mid;
            else if(midSquared < x)
               start = mid + 1;
            else
               end = mid - 1;
        }
        return end;
    }
}