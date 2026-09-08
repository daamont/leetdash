class Solution {
    
    public int answer;
    public boolean [] v;    
    
    
    void dfs(int x, int k , int[][] d) {
        
        for(int i = 0; i < d.length; i++) {
            if(!v[i] && k >= d[i][0]) {
                v[i] = true;
                dfs(x + 1 , k - d[i][1] , d);
                v[i] = false;
            }
        }
        answer = Math.max(x , answer);        
    }
    
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        v = new boolean[n];
        
        dfs(0, k , dungeons);
            
        return answer;
    }
}