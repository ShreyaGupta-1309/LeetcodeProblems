class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        char ch;
        for(int i = 0; i < strs[0].length(); i++){
            ch =strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return result.toString();
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}