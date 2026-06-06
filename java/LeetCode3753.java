public class LeetCode3753 {
    public long totalWaviness(long num1, long num2) {
        long waveCount = 0;
        for (long i=num1; i<=num2; i++){
            String numString = String.valueOf(i);
            if (numString.length() < 3){
                continue;
            }
            for (int j=0; j < numString.length() - 2; j ++){
                long start = Long.valueOf(numString.substring(j, j + 1));
                long middle = Long.valueOf(numString.substring(j + 1, j + 2));
                long end = Long.valueOf(numString.substring(j + 2, j+ 3));
                if (start > middle && middle < end){
                    waveCount ++;
                    continue;
                }
                if (start < middle && middle > end){
                    waveCount ++;
                }
            }
        }
        return waveCount;
    }

    private long dfs(int i, int waviness, int lastCmp, int lastDigit, boolean limitLow, boolean limitHigh, char[] lowS, char[] highS, long[][][][] memo) {
        if (i == highS.length) {
            return waviness;
        }
        if (!limitLow && !limitHigh && memo[i][waviness][lastCmp + 1][lastDigit] > 0) {
            return memo[i][waviness][lastCmp + 1][lastDigit] - 1;
        }

        int diffLh = highS.length - lowS.length;
        int lo = limitLow && i >= diffLh ? lowS[i - diffLh] - '0' : 0;
        int hi = limitHigh ? highS[i] - '0' : 9;

        long res = 0;
        boolean isNum = !limitLow || i > diffLh; // 前面是否填过数字
        for (int d = lo; d <= hi; d++) {
            // 当前填的数不是最高位，cmp 才有意义
            int cmp = isNum ? Integer.compare(d, lastDigit) : 0;
            int w = waviness + (cmp * lastCmp < 0 ? 1 : 0);
            res += dfs(i + 1, w, cmp, d, limitLow && d == lo, limitHigh && d == hi, lowS, highS, memo);
        }

        if (!limitLow && !limitHigh) {
            memo[i][waviness][lastCmp + 1][lastDigit] = res + 1;
        }
        return res;
    }
}
