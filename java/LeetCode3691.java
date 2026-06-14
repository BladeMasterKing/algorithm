/**
 * 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 * 你必须从 nums 中选择 恰好 k 个 不同 的非空子数组 nums[l..r]。子数组可以重叠，但同一个子数组（相同的 l 和 r）不能 被选择超过一次。
 * 子数组 nums[l..r] 的 值 定义为：max(nums[l..r]) - min(nums[l..r])。
 * 总值 是所有被选子数组的 值 之和。
 * 返回你能实现的 最大 可能总值。
 * 子数组 是数组中连续的 非空 元素序列。
 *
 * 示例 1:
 * 输入: nums = [1,3,2], k = 2
 * 输出: 4
 * 解释:
 * 一种最优的方法是：
 * 选择 nums[0..1] = [1, 3]。最大值为 3，最小值为 1，得到的值为 3 - 1 = 2。
 * 选择 nums[0..2] = [1, 3, 2]。最大值仍为 3，最小值仍为 1，所以值也是 3 - 1 = 2。
 * 将它们相加得到 2 + 2 = 4。
 *
 * 示例 2:
 * 输入: nums = [4,2,5,1], k = 3
 * 输出: 12
 * 解释:
 * 一种最优的方法是：
 * 选择 nums[0..3] = [4, 2, 5, 1]。最大值为 5，最小值为 1，得到的值为 5 - 1 = 4。
 * 选择 nums[1..3] = [2, 5, 1]。最大值为 5，最小值为 1，所以值也是 4。
 * 选择 nums[2..3] = [5, 1]。最大值为 5，最小值为 1，所以值同样是 4。
 * 将它们相加得到 4 + 4 + 4 = 12。
 *
 * 提示:
 * 1 <= n == nums.length <= 5 * 104
 * 0 <= nums[i] <= 109
 * 1 <= k <= min(105, n * (n + 1) / 2)
 */
public class LeetCode3691 {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        long total = 1 << (nums.length-2) ;
        if (k > total){
            return (long) (max - min) * total;
        }
        return (long) (max - min) * k;
    }

    public static void main(String[] args) {
        int[] nums = {11, 8};
        int k = 2;

        LeetCode3691 o = new LeetCode3691();
        System.out.println(o.maxTotalValue(nums, k));
    }
}
