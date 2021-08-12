import java.util.Arrays;

public class BinaryGap {

        public int solution(int n) {
            int[] gapArray = new int[32];
            int index = 0;
            int currentGapLength = 0;
            boolean newGap = false;
            while (n > 0) {
                if (n % 2 == 0) {
                    if (currentGapLength != 0 || newGap) {
                        currentGapLength+=1;
                    }
                } else {
                    newGap = true;
                    gapArray[index] = currentGapLength;
                    currentGapLength = 0;
                    index+=1;
                }
                n = n/2;
            }
            return Arrays.stream(gapArray).max().orElse(0);
        }

}
