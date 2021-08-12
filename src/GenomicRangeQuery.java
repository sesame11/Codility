public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[][] prefixSum = new int[S.length()][4];
        int[] result = new int[P.length];

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'A') prefixSum[i][0] = 1;
            if (c == 'C') prefixSum[i][1] = 1;
            if (c == 'G') prefixSum[i][2] = 1;
            if (c == 'T') prefixSum[i][3] = 1;
        }

        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 4; j++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }

        for (int i = 0; i < P.length; i++) {
            int left = P[i];
            int right = Q[i];

            for (int n = 0; n < 4; n++) {
                if (left == 0 && prefixSum[right][n] > 0) {
                    result[i] = n + 1;
                    break;
                }
                if (left > 0 && (prefixSum[right][n] - prefixSum[left-1][n] > 0)) {
                    result[i] = n + 1;
                    break;
                }
            }
        }
        return result;
    }
}
