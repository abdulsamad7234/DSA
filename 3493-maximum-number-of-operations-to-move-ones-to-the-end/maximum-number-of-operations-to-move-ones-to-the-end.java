class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int oneCount = 0;
        int i = 0;
        int totalOps = 0;

        while(i < n){
            if(s.charAt(i) == '0'){
                totalOps += oneCount;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
            }else{
                oneCount++;
                i++;
            }
        }
        return totalOps;
    }
}