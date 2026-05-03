class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if(sentence1.length != sentence2.length) return false;

        //build graph
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            graph.computeIfAbsent(word1, k -> new ArrayList<>()).add(word2);
            graph.computeIfAbsent(word2, k -> new ArrayList<>()).add(word1); 
        }

        //check for each word position
        for(int i=0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if(word1.equals(word2)) { //same words are similar 
                continue;
            }
            if(!isSimilar(word1, word2, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSimilar(String word1, String word2, Map<String, List<String>> graph) {
        if(!graph.containsKey(word1) || !graph.containsKey(word2)) {
            return false;
        }
        Set<String> visited = new HashSet<>();
        return dfs(word1, word2, graph, visited);
    }

    private boolean dfs(String word1, String word2, Map<String, List<String>> graph, Set<String> visited) {
        if(word1.equals(word2)) {
            return true;
        }
        visited.add(word1);

        for(String nei: graph.get(word1)) {
            if(!visited.contains(nei)) {
                if(dfs(nei, word2, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
