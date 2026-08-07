class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char sArr[] = s.toCharArray();
        Arrays.sort(sArr);
        String sortedS = new String(sArr);

        char tArr[]=t.toCharArray();
        Arrays.sort(tArr);
        String sortedT=new String(tArr);

        if(sortedS.equals(sortedT)) return true;

        return false;
    }
}