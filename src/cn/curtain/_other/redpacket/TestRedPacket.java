package cn.curtain._other.redpacket;

import java.util.Collections;
import java.util.List;

/**
 * 测试红包生成
 *
 * @author Curtain
 * @date 2018/11/21 15:46
 */
public class TestRedPacket {

    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket();
        int count = 100;
        while (count-- > 0) {
            List<Integer> list = redPacket.splitRedPacket(1000 * 100, 2);
//            List<Integer> list = redPacket.splitRedPacket(200*100, 20);
            System.out.println(list);
        }

    }
}
