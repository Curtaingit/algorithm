package cn.curtain._2sort;

/**
 * @author Curtain
 * @date 2018/9/30 10:36
 * <p>
 * 归并排序
 * 归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            //将数据复制到辅助数组
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(nums[j]) <= 0) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }

    }

    /**
     * 自顶向下归并排序
     * 将一个大数组分成两个小数组去求解。
     * 每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
     */
    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums,l,mid,h);
    }


}
