import java.util.Arrays;

public class LeetCode2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        System.out.println(Arrays.toString(cost));
        int ans = 0;
        for (int i = cost.length-1; i >=0; i-=3){
            ans += cost[i];
            if (i > 0){
                ans += cost[i-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] cost = {6,5,7,9,2};
        LeetCode2144 o = new LeetCode2144();
        System.out.println(o.minimumCost(cost));
    }
}
