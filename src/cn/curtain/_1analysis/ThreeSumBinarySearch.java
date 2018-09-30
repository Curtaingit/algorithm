package cn.curtain._1analysis;

import java.util.Arrays;

/**
 * @author Curtain
 * @date 2018/9/29 14:43
 * <p>
 * 通过将数组先排序，对两个元素求和
 * 并用二分查找方法查找是否存在该和的相反数
 * 如果存在，就说明存在三元组的和为 0。
 * <p>
 * 应该注意的是，只有数组不含有相同元素才能使用这种解法，否则二分查找的结果会出错。
 * 该方法可以将 ThreeSum 算法增长数量级降低为 O(N^2logN)。
 */
public class ThreeSumBinarySearch implements ThreeSum {
    @Override
    public int count(int[] nums) {
        //这里默认是以排序 去重的数组
//        Arrays.sort(nums); //理想情况为(N log N)  最差为(N^2)
        int N = nums.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int target = -nums[i] - nums[j];
                int index = search(nums, target);
                //这里的index要大于j (保证这种等式只出现一次  -1 + 0 + 1，  1 + 0 + -1)  否则会统计出错;
                if (index > j) {
//                    System.out.println(nums[i] + "." + nums[j] + "." + nums[index]);
                    count++;
                }
            }
        }

        return count;
    }

    private static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //未找到返回-1
        return -1;
    }
}
