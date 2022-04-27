class Solution {
    private class UnionFind {

        public int[] size;
        public int[] parent;

        UnionFind(int count) {
            size = new int[count];
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        int union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return size[pRoot];
            }
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
                return size[pRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                return size[qRoot];
            }

        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> swaps) {
        int N = s.length();

        UnionFind uf = new UnionFind(N);
        for (List<Integer> swap : swaps) {
            uf.union(swap.get(0), swap.get(1));
        }


        Map<Integer, List<Character>> graphs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int head = uf.find(i);
            List<Character> characters = graphs.computeIfAbsent(head, (dummy) -> new LinkedList<>());
            characters.add(s.charAt(i));
        }

        for (List<Character> characters : graphs.values()) {
            Collections.sort(characters);
        }

        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            List<Character> characters = graphs.get(uf.find(i));
            char currentMin = characters.remove(0);
            sb.append(currentMin);
        }
        return sb.toString();
    }
}