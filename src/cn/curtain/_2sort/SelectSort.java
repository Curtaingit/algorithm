package cn.curtain._2sort;

/**
 * @author Curtain
 * @date 2018/9/29 16:47
 *
 * 选择排序
 * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
 * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
 * 不断进行这样的操作，直到将整个数组排序。
 *
 * 选择排序需要 ~N2/2 次比较和 ~N 次交换   它的
 * 运行时间与输入无关 已经排序的数组也需要这么多的比较和交换操作。
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                //小于则重新确定最小值
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            //将最小的元素换到当前位置
            swap(nums, i, min);
        }
    }


}
