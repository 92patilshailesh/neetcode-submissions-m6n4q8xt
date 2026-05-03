class Solution {
    public int minTransfers(int[][] transactions) {

        Map<Integer, Integer> balance = new HashMap<>();
        for(int[] t : transactions) {
            int from = t[0];
            int to = t[1];
            int amount = t[2];

            balance.put(from, balance.getOrDefault(from, 0) + amount);
            balance.put(to, balance.getOrDefault(to, 0) - amount);
        }

        List<Integer> debt = new ArrayList<>();
        for(int val : balance.values()) {
            if(val != 0) {
                debt.add(val);
            }
        }
        return dfs(0, debt);
        
    }
    private int dfs(int i, List<Integer> debts) {
        while(i < debts.size() && debts.get(i) == 0) {
            i++;
        }
        if(i == debts.size()) {
            return 0;
        }
        int minTransactions = Integer.MAX_VALUE;
        int currDebt = debts.get(i);

        for(int j = i+1; j < debts.size(); j++) {
            if(currDebt * debts.get(j) < 0) {
                debts.set(j, debts.get(j) + currDebt);
                minTransactions = Math.min(minTransactions, 1 + dfs(i+1, debts));
                debts.set(j, debts.get(j) - currDebt);
            
                if(debts.get(j) + currDebt == 0) {
                    break;
                }
            }
        }
        return minTransactions;
    }
}
