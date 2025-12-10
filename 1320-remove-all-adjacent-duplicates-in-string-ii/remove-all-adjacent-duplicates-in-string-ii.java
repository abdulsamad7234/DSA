class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && st.peek().ch == s.charAt(i)){
                if(st.peek().freq + 1 == k){
                    st.pop();
                }else{
                    st.peek().freq++;
                }
            }else{
                st.push(new Pair(s.charAt(i), 1));
            }
        }

        StringBuilder stb = new StringBuilder("");
        while(!st.isEmpty()){
            Pair curr = st.pop();
            for(int i = 0; i < curr.freq; i++){
                stb.append(curr.ch);
            }
        }

        return stb.reverse().toString();
    }

    class Pair{
        char ch;
        int freq;

        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}