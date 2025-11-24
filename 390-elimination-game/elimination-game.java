class Solution {
    public int lastRemaining(int n) {
        return helper(1, 1, true, n);
        }

    public int helper(int head, int step, boolean turn, int remain){
        if(remain == 1){
            return head;
        }
        if(turn || remain % 2 == 1){
            head = head + step;
        }
        remain = remain / 2;
        step = step * 2;
        return helper(head, step, !turn, remain);
    }
}