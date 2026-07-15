class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        int odd = 1;
        int even = 2;

        for(int i = 0; i < n; i++) {
            sumOdd += odd;
            sumEven += even;
            odd += 2;
            even += 2;
        }

        return sumEven - sumOdd;   
    }
}