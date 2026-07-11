class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        
        int[] size = new int[n];
        Arrays.fill(size, 1);

        for(int[] edge: edges) {
            union(edge[0], edge[1], par, size);
        }

        Map<Integer, Integer> count = new HashMap<>();

        for(int[] edge: edges) {
            int parent = findParent(edge[0], par);
            count.put(parent, count.getOrDefault(parent, 0) + 1);
        }

        int ans = 0;

        for(int key: count.keySet()) {
            int nodes = size[key];
            int edge = count.get(key);

            if(edge == ((nodes * (nodes - 1)) / 2)) {
                ans++;
            }
        }

        for(int i = 0; i < n; i++) {
            int parent = findParent(i, par);
            if(size[parent] == 1) ans++;
        }

        return ans;
    }

    private int findParent(int a, int[] par) {
        if(a == par[a]) return a;
        return par[a] = findParent(par[a], par);
    }

    private void union(int a, int b, int[] par, int[] size) {
        a = findParent(a, par);
        b = findParent(b, par);

        if(a == b) return;

        if(size[a] >= size[b]) {
            par[b] = a;
            size[a] += size[b];
        }
        else {
            par[a] = b;
            size[b] += size[a];
        }
    }
}