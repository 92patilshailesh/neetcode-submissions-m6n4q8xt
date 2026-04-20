class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

}
class Solution {
    private Set<String> res;
    private boolean[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            root.addWord(word);
        }
        int rows = board.length;
        int cols = board[0].length;
        res = new HashSet();
        visit = new boolean[rows][cols];

        for(int i =0 ; i < rows; i++) {
            for(int j =0 ; j < cols ; j++) {
                dfs(board, i,j,root, "");
            }
        }
        return new ArrayList(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if(r < 0 || c < 0 || r>=rows || c >=cols || visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }
        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord) {
            res.add(word);
        }
        dfs(board, r+1 , c, node, word);
        dfs(board, r-1 , c, node, word);
        dfs(board, r , c+1, node, word);
        dfs(board, r , c-1, node, word);
        visit[r][c] = false;
    }
}
