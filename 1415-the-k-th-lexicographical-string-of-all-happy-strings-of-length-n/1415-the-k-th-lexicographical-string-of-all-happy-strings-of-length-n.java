class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        StringBuilder ans = new StringBuilder();
        char prev = '#';

        for (int pos = 0; pos < n; pos++) {
            List<Character> choices = new ArrayList<>();

            for (char ch : new char[]{'a', 'b', 'c'}) {
                if (ch != prev) {
                    choices.add(ch);
                }
            }

            int remaining = n - pos - 1;
            int blockSize = 1 << remaining;

            for (char ch : choices) {
                if (k > blockSize) {
                    k -= blockSize;
                } else {
                    ans.append(ch);
                    prev = ch;
                    break;
                }
            }
        }

        return ans.toString();
    }
}