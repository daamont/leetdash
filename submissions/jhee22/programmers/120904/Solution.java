class Solution {
    public int solution(int num, int k) {
        String str_num = String.valueOf(num); 
        for (int i = 0; i < str_num.length(); i++) {
            if (str_num.charAt(i) == str_k.charAt(0)) {
                return i+1; 
            }
        }
        return -1;
    }
}