class Solution {
    //O(K * N + V * (V + E))
    /*
    V = number of unique synonym words
    E = number of synonym relations
    N = number of words in the sentence
    K = number of generated sentences

    */
    public List<String> generateSentences(List<List<String>> synonyms, String text) {

        Map<String, List<String>> graph = new HashMap<>();

        //build graph
        for(List<String> pair : synonyms) {
            String a = pair.get(0);
            String b = pair.get(1);

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        //for each word find all reachable  synonyms
        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for(String word : graph.keySet()) {
            if (!visited.contains(word)) {
                List<String> group = new ArrayList();
                dfs(word, graph, visited, group);
                Collections.sort(group);
                for(String w : group)
                    map.put(w, group);
            }
        } 

        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();

        backtrack(words, 0, new ArrayList<>(), map, result);
        Collections.sort(result);
        return result;
        
    }

    private void dfs(String word, Map<String, List<String>> graph, Set<String> visited, List<String> group) {

        if(visited.contains(word)) {
            return;
        }

        visited.add(word);
        group.add(word);
        for(String next: graph.getOrDefault(word, new ArrayList<>())) {
            dfs(next, graph, visited, group);
        }
    }

    private void backtrack(String[] words, int i, List<String> path, Map<String, List<String>> map, List<String> result) {
        if(i == words.length) {
            result.add(String.join(" ", path));
            return;
        }

        String word = words[i];

        if(map.containsKey(word)) {
            for(String choice : map.get(word)) {
                path.add(choice);
                backtrack(words, i +1, path, map,result);
                path.remove(path.size() - 1);
            }
        }
        else {
            path.add(word);
            backtrack(words, i+1, path, map, result);
            path.remove(path.size() - 1);
        }

    }
}
