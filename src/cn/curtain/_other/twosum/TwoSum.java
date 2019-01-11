package cn.curtain._other.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * 从数组中返回两个值相加等于目标值的下标
 *
 * @author Curtain
 * @date 2018/11/23 14:18
 */
public class TwoSum {

    /**
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwo1(int[] nums, int target) {
        int[] result;

        for (int i = 0; i < nums.length - 1; i++) {
            //避免多次访问数组
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (a + nums[j] == target) {
                    result = new int[]{i, j};
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度O（N）
     * 利用Map Key存放目标值（当前的差值）Value就是当前的下标
     * 每次遍历是 查看当前遍历的值是否等于差值，如果等于，说明相加就等于目标值
     * 然后取出map中的value,和本次遍历的小标就是结果了。
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwo2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            //遍历当前值  是否是组成需要的差值。
            if (map.containsKey(nums[i])) {
                result = new int[]{map.get(nums[i]), i};

            }
            map.put(target-nums[i],i);
        }
        return result;
    }
}
