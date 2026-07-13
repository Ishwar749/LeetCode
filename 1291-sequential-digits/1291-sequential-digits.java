class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] dig = new int[10];

        for(int i = 0; i < 10; i++) dig[i] = i;

        List<Integer> answer = new ArrayList<>();

        for(int i = 1; i < 10; i++) {
            int num = 0;
            for(int j = i; j < 10; j++) {
                num = num * 10;
                num += j;

                if(num >= low && num <= high) answer.add(num);
            }
        }

        Collections.sort(answer);
        return answer;
    }
}