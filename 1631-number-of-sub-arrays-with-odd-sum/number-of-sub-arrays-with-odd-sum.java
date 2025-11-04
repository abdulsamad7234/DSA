class Solution {
    public int numOfSubarrays(int[] arr) {
        int evens = 1;
        int odds = 0;
        int totalOdds = 0;

        int prefixSum = 0;

        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];
            if(prefixSum % 2 == 0){
                totalOdds += odds;
                evens++;
            }else{
                totalOdds += evens;
                odds++;
            }
            totalOdds %= 1000000007;
        }
        return totalOdds;
    }
}