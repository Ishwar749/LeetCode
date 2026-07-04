class Solution {
    public int minScore(int n, int[][] roads) {
        int[] par = new int[n + 1];
        for(int i = 0; i <= n; i++) par[i] = i;
        int[] rank = new int[n + 1];

        for(int[] road: roads) {
            union(road[0], road[1], par, rank);
        }

        int answer = Integer.MAX_VALUE;
        int parent = findParent(1, par);

        for(int[] road: roads) {
            if(findParent(road[0], par) == parent) {
                answer = Math.min(answer, road[2]);
            }
        }

        return answer;
    }

    private int findParent(int a,int[] par) {
        if(a == par[a]) return a;

        return par[a] = findParent(par[a], par);
    }

    private void union(int u, int v, int[] par, int[] rank) {
        u = findParent(u, par);
        v = findParent(v, par);

        if(par[u] == par[v]) return;

        if(rank[u] > rank[v]) {
            par[v] = u;
        } 
        else if(rank[v] > rank[u]) {
            par[u] = v;
        }
        else {
            par[v] = u;
            rank[u]++;
        }
    }
}