class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] pre = new int[n];

        if (s.charAt(0) == '1') pre[0] = 1;

        for (int i = 1; i < n; i++) {
            char cur = s.charAt(i);

            if (cur == '1') {
                pre[i] = 1;
            }

            pre[i] += pre[i - 1];
        }

        int minLength = n + 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isBeautiful(i, j, k, pre)) {
                    minLength = Math.min(minLength, (j - i) + 1);
                }
            }
        }

        if (minLength == n + 1) return "";


        List<String> sbs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int curLen = (j - i) + 1;
                if(isBeautiful(i, j, k, pre) && curLen == minLength) {
                    sbs.add(s.substring(i, j + 1));
                }
            }
        }

        Collections.sort(sbs);
        return sbs.get(0);
    }

    private boolean isBeautiful(int i, int j, int k, int[] pre) {
        int count = pre[j];
        if(i - 1 >= 0) count -= pre[i - 1];

        return count == k;
    }


}