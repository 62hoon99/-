class Solution {
    int solution(int[][] land) {
        int answer = 0;
        if (land.length != 1) {
            dP(land, 1);
        }
        
        for (int i = 0; i < 4; i++) {
            if (answer < land[land.length - 1][i]) {
                answer = land[land.length - 1][i];
            }
        }
        return answer;
    }
    
    private void dP(int[][]land, int depth) {
        if (depth == land.length) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int k = 0; k < 4; k++) {
                if (i != k && max < land[depth][i] + land[depth - 1][k]) {
                    max = land[depth][i] + land[depth - 1][k];
                }
            }
            land[depth][i] = max;
        }
        
        dP(land, depth + 1);
    }
}