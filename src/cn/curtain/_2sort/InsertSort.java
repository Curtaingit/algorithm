package cn.curtain._2sort;

/**
 * @author Curtain
 * @date 2018/9/29 17:19
 *
 * 插入排序
 * 对于数组 {3, 5, 2, 4, 1}，插入排序每次只能交换相邻元素
 * 令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。
 * 插入排序的复杂度取决于数组的初始顺序，如果数组已经部分有序了，逆序较少，那么插入排序会很快。
 *
 * 平均情况下插入排序需要 ~N2/4 比较以及 ~N2/4 次交换
 * 最坏的情况下需要 ~N2/2 比较以及 ~N2/2 次交换
 * 最好的情况下需要 N-1 次比较和 0 次交换
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        //i从第二个  到最后一个
        for (int i = 1; i < N; i++) {
            //如果右边的数小于左边那么久互换  一直到符合有序位置  j的起始值由i确定
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j-1);
            }
        }
    }
}
