class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        char[] chars = new char[26];
        int ind = 0;

        for(char c = 'a'; c <= 'z'; c++) {
            chars[ind] = c;
            ind++;
        }

        for(String word: words) {
            int sum = getSum(word, weights);
            char toAdd = chars[25 - (sum%26)];
            result.append(toAdd);
        }

        return result.toString();
    }

    private int getSum(String word, int[] weights) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++) {
            sum += weights[word.charAt(i) - 'a'];
        }
        return sum;
    }
}