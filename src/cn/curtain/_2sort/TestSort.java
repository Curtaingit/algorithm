package cn.curtain._2sort;

import java.util.*;

/**
 * @author Curtain
 * @date 2018/9/30 9:47
 */
public class TestSort {

    public static void main(String[] args) {
        final Integer count = 8;
        long time;

        ShellSort<Integer> shellSort = new ShellSort<>();
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        SelectSort<Integer> selectSort = new SelectSort<>();
        InsertSort<Integer> insertSort = new InsertSort<>();
        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();


        //当数据到一千万时  15s
//        time = System.currentTimeMillis();
//        shellSort.sort(initData(count));
//        System.out.println("希尔排序:" + String.valueOf(System.currentTimeMillis() - time) + "ms");

//        //当数据到十万时  12s   最耗时     稳定
//        time = System.currentTimeMillis();
//        bubbleSort.sort(initData(count));
//        System.out.println("冒泡排序:" + String.valueOf(System.currentTimeMillis() - time) + "ms");
//

//
//        //当数据到十万时 8s  优于冒泡  + 选择    但不稳定
//        time = System.currentTimeMillis();
//        selectSort.sort(initData(count));
//        System.out.println("选择排序:" + String.valueOf(System.currentTimeMillis() - time) + "ms");
//
//
//        //当数据到十万时   10s    优于冒泡  稳定
//        time = System.currentTimeMillis();
//        insertSort.sort(initData(count));
//        System.out.println("插入排序:" + String.valueOf(System.currentTimeMillis() - time) + "ms");

        //当数据到一千万时  10s   优于希尔 并且比希尔排序稳定
//        time = System.currentTimeMillis();
//        mergeSort.sort(initData(count));
//        System.out.println("归并排序:" + String.valueOf(System.currentTimeMillis() - time) + "ms");


        time = System.currentTimeMillis();
        quickSort.sort(initData(count));
        System.out.println("快速排序:" + String.valueOf(System.currentTimeMillis() - time) + "ms");



    }


    private static Integer[] initData(int length) {
        Integer[] nums = new Integer[length];
        for (int i = 0; i < length; i++) {
            nums[i] = ((int) (0.5 * length - (Math.random() * length)));
        }

        //去重
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//        nums = set.toArray(new Integer[set.size()]);


        return nums;
    }

    private static void print(Integer[] nums) {
        final int N = nums.length;
        for (int i = 0; i < N; i++) {
            System.out.println(nums[i]);
        }
    }

}
