class Excel {
    Formula[][] formulas;
    class Formula {
        HashMap<String , Integer> cells;
        int val;

        Formula(HashMap<String, Integer> c, int v) {
            val = v;
            cells = c;
        }
    }

    Stack<int[]> stack = new Stack<>();

    public Excel(int height, char width) {
        formulas = new Formula[height][(width-'A') + 1];
        
    }
    
    public void set(int r, char c, int v) {
        formulas[r-1][c-'A'] = new Formula(new HashMap<String, Integer>(), v);
        topologicalSort(r-1, c-'A');
        execute_stack();
        
    }

    public void topologicalSort(int r, int c) {
        for(int i=0; i < formulas.length; i++) {
            for(int j=0; j < formulas[0].length; j++) {
                if(formulas[i][j] != null && formulas[i][j].cells.containsKey("" + (char) ('A' + c) + (r + 1))) {
                    topologicalSort(i, j);
                }
            }
        }
        stack.push(new int[] {r, c});
    }

    public void execute_stack() {
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            if(formulas[top[0]][top[1]].cells.size() > 0) {
                calculate_sum(top[0], top[1], formulas[top[0]][top[1]].cells);
            }
        }
    }

    public int calculate_sum(int r, int c, HashMap<String, Integer> cells) {
        int sum = 0;
        for(String s : cells.keySet()) {
            int x = Integer.parseInt(s.substring(1)) - 1;
            int y = s.charAt(0) - 'A';
            sum += (formulas[x][y] != null ? formulas[x][y].val : 0) * cells.get(s); 
        }
        formulas[r][c] = new Formula(cells, sum);
        return sum;
    } 
    
    public int get(int r, char c) {
        if(formulas[r-1][c-'A'] == null) return 0;
        return formulas[r -1][c-'A'].val;
        
    }
    
    public int sum(int r, char  c, String[] numbers) {
        HashMap<String, Integer> cells = (HashMap<String, Integer>) convert(numbers);
        int summ = calculate_sum(r-1, c-'A', cells);
        // Remove set call to avoid overwriting formula map with empty one
        formulas[r-1][c-'A'] = new Formula(cells, summ);
        return summ;
        
    }

    public Map<String, Integer> convert(String[] numbers) {
        Map<String, Integer> res = new HashMap<>();
        for(String s : numbers) {
            if(s.indexOf(':') < 0) {
                res.put(s, res.getOrDefault(s, 0) +1);
            }
            else {
                String[] cells = s.split(":");
                int si = Integer.parseInt(cells[0].substring(1));
                int ei = Integer.parseInt(cells[1].substring(1));

                char sj = cells[0].charAt(0);
                char ej = cells[1].charAt(0);

                for(int i = si; i <=ei; i++) {
                    for(char j = sj; j <=ej; j++) {
                        res.put(""+j+i, res.getOrDefault(""+j+i, 0) + 1);
                    }
                }
            }
        }
        return res;
    }
}