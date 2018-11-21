package cn.curtain._other.redpacket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Curtain
 * @date 2018/11/21 15:20
 */
public class RedPacket {

    /**
     * 红包最小值1分
     */
    private static final int MIN_MONEY = 1;

    /**
     * 红包最大值200元
     */
    private static final int MAX_MONEY = 200 * 100;

    /**
     * 平均值小于最小值
     */
    private static final int LESS = -1;

    /**
     * 平均值大于最大值
     */
    private static final int MORE = -2;

    private static final int OK = 0;

    private static final double TIMES = 2.1F;


    /**
     * 根据输入的总金额个总红包个数 返回随机红包金额
     *
     * @param money
     * @param count
     * @return
     */
    public List<Integer> splitRedPacket(int money, int count) {
        List<Integer> result = new ArrayList<>();

        //计算出 最大红包的金额 (平均值的2.1倍)
        int max = (int) (money / count * TIMES);
        max = max > MAX_MONEY ? MAX_MONEY : max;

        while (count > 0) {
            //随机获取红包
            int redPacket = randomRedPacket(money, MIN_MONEY, max, count);
            result.add(redPacket);
            //减少总金额
            money -= redPacket;
            //减少待分配红包个数
            count--;
        }

        return result;
    }

    /**
     * 随机产生一个符合条件的红包金额
     *
     * @param money
     * @param minMoney
     * @param maxMoney
     * @param count
     * @return
     */
    private int randomRedPacket(int money, int minMoney, int maxMoney, int count) {

        //只剩一个红包  直接返回剩余金额
        if (count == 1) {
            return money;
        }

//        if (minMoney==maxMoney){
//            return minMoney;
//        }

        //如果最大金额大于了剩余金额  那么剩余金额就是最大金额
        maxMoney = maxMoney > money ? money : maxMoney;

        //在最大金额和最小金额中 随机产生一个金额
        int redPacket = (int) (Math.random() * (maxMoney - minMoney) + minMoney);

        int lastMoney = money - redPacket;

        int status = checkMoney(lastMoney, count - 1);

        //正常结果
        if (OK == status) {
            return redPacket;
        }

        //金额小于最小值
        if (LESS == status) {
            //重写递归生成
            return randomRedPacket(money, minMoney, maxMoney, count);
        }

        //金额大于最大值
        if (MORE == status) {
            //重写递归生成
            return randomRedPacket(money, minMoney, maxMoney, count);
        }

        return redPacket;
    }

    /**
     * 校验剩余的金额平均值是否在最小值和最大值范围内
     *
     * @param lastMoney
     * @param count
     * @return
     */
    private int checkMoney(int lastMoney, int count) {
        double avg = lastMoney / count;
        if (avg < MIN_MONEY) {
            return LESS;
        }
        if (avg > MAX_MONEY) {
            return MORE;
        }
        return OK;
    }


}
