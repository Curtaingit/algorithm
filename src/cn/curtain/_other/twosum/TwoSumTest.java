package cn.curtain._other.twosum;

/**
 * @author Curtain
 * @date 2018/11/23 14:27
 */
public class TwoSumTest {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int[] result = TwoSum.getTwo1(nums, 8);
        if ((result == null)) {
            System.out.println("no find");
        } else {
            System.out.println(result[0] + "_____" + result[1]);
        }


        int[] two1 = TwoSum.getTwo2(nums, 8);
        System.out.println(two1[0] +"_____"+ two1[1]);

    }
}
