public class LeetCode3751 {
    public int totalWaviness(int num1, int num2) {
        int waveCount = 0;
        for (int i=num1; i<=num2; i++){
            String numString = String.valueOf(i);
            if (numString.length() < 3){
                continue;
            }
            for (int j=0; j < numString.length() - 2; j ++){
                int start = Integer.valueOf(numString.substring(j, j + 1));
                int middle = Integer.valueOf(numString.substring(j + 1, j + 2));
                int end = Integer.valueOf(numString.substring(j + 2, j+ 3));
                if (start > middle && middle < end){
                    System.out.println(start + " > " + middle + " < " + end);
                    waveCount ++;
                    continue;
                }
                if (start < middle && middle > end){
                    System.out.println(start + " < " + middle + " > " + end);
                    waveCount ++;
                }
            }
        }
        return waveCount;
    }

    public static void main(String[] args) {
        int num1 = 4848;
        int num2 = 4848;

        LeetCode3751 o = new LeetCode3751();
        System.out.println(o.totalWaviness(num1, num2));
    }
}
