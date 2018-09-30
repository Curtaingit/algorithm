package cn.curtain._2sort;

/**
 * @author Curtain
 * @date 2018/9/29 17:02
 * <p>
 * 冒泡排序
 * 从左到右不断交换相邻逆序的元素，
 * 在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * <p>
 * 在一轮循环中，如果没有发生交换，就说明数组已经是有序的，此时可以直接退出。
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isOrder = false;

        for (int i = N - 1; i > 0 && !isOrder; i--) {
            isOrder = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    //有交换代表还是 无序的
                    isOrder = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
