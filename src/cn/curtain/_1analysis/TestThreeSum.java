package cn.curtain._1analysis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Curtain
 * @date 2018/9/29 15:37
 */
public class TestThreeSum {

    public static void main(String[] args) {

        //构造数组
        int[] data = initData(100000);
        int count;
        long time;

        //测试数组
//        data = new int[]{-3, -2, -1, 0, 1, 2};

        //数组去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        Integer[] arrayResult = set.toArray(new Integer[set.size()]);

        //构造需要的数组
        int[] nums = new int[arrayResult.length];



        for (int i = 0; i < arrayResult.length; i++) {
//            System.out.println(arrayResult[i]);
            nums[i] = arrayResult[i];
        }

        //排序
        Arrays.sort(nums);

        ThreeSumSlow threeSumSlow = new ThreeSumSlow();
        ThreeSumBinarySearch threeSumBinarySearch = new ThreeSumBinarySearch();
        ThreeSumTwoPointer threeSumTwoPointer = new ThreeSumTwoPointer();
//
//        time = System.currentTimeMillis();
//        count = threeSumSlow.count(nums);
//        System.out.println("threeSumSlow  时间：" + String.valueOf(System.currentTimeMillis() - time) + "次数：" + count);

//        time = System.currentTimeMillis();
//        count = threeSumBinarySearch.count(nums);
//        System.out.println("threeSumBinarySearch  时间：" + String.valueOf(System.currentTimeMillis() - time) + "次数：" + count);

        time = System.currentTimeMillis();
        count = threeSumTwoPointer.count(nums);
        System.out.println("threeSumTwoPointer  时间：" + String.valueOf(System.currentTimeMillis() - time) + "次数：" + count);


    }


    private static int[] initData(int length) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) (0.5 * length - (Math.random() * length));
        }
        return nums;
    }

}
