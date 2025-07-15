class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;

        int countVowels = 0;
        int countConsonants = 0;

        for(char letter : word.toCharArray()){
            if(!Character.isLetterOrDigit(letter)) return false;
            
            if(Character.isLetter(letter)){
                char lower = Character.toLowerCase(letter);
                if(isVowel(lower)){
                    countVowels++;
                }else {
                    countConsonants++;
                }
            }
        }
        if(countVowels == 0 || countConsonants == 0) return false;

        return true;
    }
        private boolean isVowel(char letter){
        return (letter == 'a'|| letter == 'e'|| letter == 'i'|| letter == 'o'|| letter == 'u');
    }
}