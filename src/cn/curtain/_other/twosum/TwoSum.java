package cn.curtain._other.twosum;

/**
 * 从数组中返回两个值相加等于目标值的下标
 *
 * @author Curtain
 * @date 2018/11/23 14:18
 */
public class TwoSum {

    /**
     * 时间复杂度O(n^2)
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

}
