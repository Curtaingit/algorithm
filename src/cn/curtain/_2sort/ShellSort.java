package cn.curtain._2sort;

/**
 * @author Curtain
 * @date 2018/9/30 9:18
 * <p>
 * 希尔排序
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 * 希尔排序的运行时间达不到平方级别，使用递增序列 1, 4, 13, 40, ...
 * 希尔排序所需要的比较次数不会超过 N 的若干倍乘于递增序列的长度
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            //1,4,13,40,...
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }

    }
}
