class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] arr =s1.toCharArray();
        int x = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != s2.charAt(i)){
                if(x == -1) x = i;
                else{
                    char temp = arr[i];
                    arr[i] = arr[x];
                    arr[x] = temp;
                    return String.valueOf(arr).equals(s2);
                }
            }
        }
        return s1.equals(s2);
    }
}