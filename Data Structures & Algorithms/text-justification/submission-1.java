class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0, i = 0;

        while(i < words.length) {
            //if current word can fit in line
            if(length + words[i].length() + line.size() <= maxWidth) {
                line.add(words[i]);
                length += words[i].length();
                i++;
            }
            else {
                //Line complete
                int extra_space = maxWidth - length;
                int maxLineSize = Math.max(1, line.size() - 1);
                int reminder = extra_space % maxLineSize;
                int space = extra_space / maxLineSize;

                for(int j = 0 ; j < maxLineSize; j++) {
                    line.set(j, line.get(j) + " ".repeat(space));
                    if(reminder > 0) {
                        line.set(j, line.get(j) + " ");
                        reminder--;
                    }
                }

                res.add(String.join("", line));
                line.clear();
                length = 0;
            }
        }
        
        //handling last line
        String last_line = String.join(" ", line);
        int trail_space = maxWidth - last_line.length();
        res.add(last_line + " ".repeat(trail_space));
        return res;
    }
}