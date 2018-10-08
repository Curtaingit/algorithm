package cn.curtain._2sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Curtain
 * @date 2018/9/30 13:04
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {

    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray();
    }

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && j != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i > j)
                break;
            swap(nums, l, j);
            return j;
        }

        return j;
    }
}
