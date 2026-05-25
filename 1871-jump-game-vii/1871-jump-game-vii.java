class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        int[] sum = new int[len];

        if(s.charAt(len - 1) != '0') return false;

        sum[minJump] = 1;
        if(maxJump + 1 < len) sum[maxJump + 1] = -1;

        for(int i = 1; i < len; i++) {
            sum[i] += sum[i - 1];
            if(s.charAt(i) == '0' && sum[i] > 0) {
                if(i + minJump < len) sum[i + minJump] += 1;
                if(i + maxJump + 1 < len) sum[i + maxJump + 1] += -1;
            }
        }

        if(sum[len - 1] > 0) return true;
        return false;
    }
}