class Solution {
    public char kthCharacter(int k) {
        int index = k - 1;
        int incre = 0;
        while(index > 0){
            long p = 1;
            while(p * 2 <= index){
                p *= 2;
            }
            incre++;
            index -= p;
        }
        return(char)('a' +( incre % 26));
    }
}