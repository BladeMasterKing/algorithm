public class LeetCode3633 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minEndTime = Integer.MAX_VALUE;;
        for (int i=0;i<landStartTime.length;i++){
            int landOpenTime = landStartTime[i];
            int landDuringTime = landDuration[i];
            int landEndTime = landOpenTime + landDuringTime;
            for (int j=0;j<waterStartTime.length;j++){
                int waterOpenTime = waterStartTime[j];
                int waterDuringTime = waterDuration[j];
                int waterEndTime = waterOpenTime + waterDuringTime;
                int thisMinTime = 0;
                // 先陆地后水上
                if (landEndTime > waterOpenTime){
                    thisMinTime = landEndTime + waterDuringTime;
                } else {
                    thisMinTime = waterEndTime;
                }
                minEndTime = Math.min(thisMinTime, minEndTime);
                // 先水上后陆地
                if (waterEndTime > landOpenTime){
                    thisMinTime = waterEndTime + landDuringTime;
                } else {
                    thisMinTime = landEndTime;
                }
                minEndTime = Math.min(thisMinTime, minEndTime);
            }
        }
        return minEndTime;
    }

    public static void main(String[] args) {
        int[] landStartTime = {2,8};
        int[] landDuration = {4,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        LeetCode3633 o = new LeetCode3633();
        System.out.println(o.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}
