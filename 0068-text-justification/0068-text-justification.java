class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n;){
            int start = i;
            int cnt = 0;
            cnt += words[i].length();
            i++;
            while(i < n && cnt + 1 + words[i].length() <= maxWidth){
                cnt += words[i].length() + 1;
                i++;
            }
            StringBuilder sb = new StringBuilder();
            int num = i - start;
            int pad = 1;
            int extraPad = 0;
            sb.append(words[start]);
            if(num > 1 && i < n){
                pad += (maxWidth - cnt) /(num - 1);
                extraPad = (maxWidth - cnt) % (num - 1);
            }
            for(int j = start + 1; j < i; j++){
                if(extraPad-- > 0){
                    sb.append(" ");
                }
                sb.append(" ".repeat(pad)).append(words[j]);
            }
            if(i == n || num == 1){
                sb.append(" ".repeat(maxWidth - cnt));
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}