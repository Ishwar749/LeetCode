class Solution {

    static class Edge implements Comparable<Edge>{
        int nei;
        int wei;

        public Edge(int nei, int wei) {
            this.nei = nei;
            this.wei = wei;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.wei, other.wei);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());

        for (int[] time: times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000);

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int u = cur.nei;
            int w = cur.wei;

            for (Edge nei: graph.get(u)) {
                int newCost = w + nei.wei;

                if (newCost < dist[nei.nei]) {
                    dist[nei.nei] = newCost;
                    queue.add(new Edge(nei.nei, newCost));
                }
            }
        }

        int result = -1;

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dist[i]);
        }

        return (result == 1000000) ? -1 : result;
    }
}