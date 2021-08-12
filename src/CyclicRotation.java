import java.util.Arrays;

class CyclicRotation {
    public static int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        if (A.length == K) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            int targetId = (i + K) % A.length;
            result[targetId] = A[i];
        }
        return result;
    }
}
