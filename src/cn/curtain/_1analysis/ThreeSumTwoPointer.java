package cn.curtain._1analysis;

import java.util.Arrays;

/**
 * @author Curtain
 * @date 2018/9/29 15:17
 * <p>
 * 更有效的方法是先将数组排序，然后使用双指针进行查找，时间复杂度为 O(N2)。
 */
public class ThreeSumTwoPointer implements ThreeSum {

    @Override
    public int count(int[] nums) {
        int N = nums.length;
        int count = 0;
        //这里默认是以排序 去重的数组  所以下面也不需要跳过相等的数据
//        Arrays.sort(nums);

        //让第一个数 只能获取到N-2  因为是三个数相加
        for (int i = 0; i < N - 2; i++) {
            //low从指向第二个数开始， high指向最后一个数开始
            int low = i + 1, high = N - 1, target = -nums[i];
            //跳过相等的数字
//            if (i>0 && nums[i]==nums[i-1]) continue;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
//                    System.out.println(nums[i]+"."+nums[low]+"."+nums[high]);
                    count++;
                    //跳过相等的数字
//                    while (low<high&&nums[low]==nums[low+1]) low++;
//                    while (low<high&&nums[high]==nums[high-1]) high--;
                    low++;
                    high--;
                }else if (sum<target){
                    low++;
                }else {
                    high--;
                }
            }

        }
        return count;
    }
}
