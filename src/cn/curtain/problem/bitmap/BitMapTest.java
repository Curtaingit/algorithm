package cn.curtain.problem.bitmap;

/**
 * @author Curtain
 * @date 2018/10/17 15:10
 */
public class BitMapTest {
    private long length;
    private static byte[] bitsMap;
    private static final byte[] BIT_VALUE = { 00000001, 00000002};
    public BitMapTest(long length) {
        this.length = length;
        // 根据长度算出，所需数组大小
        bitsMap = new byte[(byte) (length >> 5) + ((length & 31) > 0 ? 1 : 0)];
    }
    /**
     * 根据长度获取数据 比如输入63，那么实际上是确定数62是否在bitsMap中
     *
     * @return index 数的长度
     * @return 1:代表数在其中 0:代表
     */
    public int getBit(long index) {
        if (index < 0 || index > length) {
            throw new IllegalArgumentException("length value illegal!");
        }
        int intData = (int) bitsMap[(int) ((index - 1) >> 5)];
        return ((intData & BIT_VALUE[(int) ((index - 1) & 31)])) >>> ((index - 1) & 31);
    }
    /**
     * @param index
     *            要被设置的值为index - 1
     */
    public void setBit(long index) {
        if (index < 0 || index > length) {
            throw new IllegalArgumentException("length value illegal!");
        }
        // 求出该index - 1所在bitMap的下标
        byte belowIndex = (byte) ((index - 1) >> 5);
        // 求出该值的偏移量(求余)
        int offset = (int) ((index - 1) & 31);
        int inData = bitsMap[belowIndex];
        bitsMap[belowIndex] = (byte) (inData | BIT_VALUE[offset]);
    }
    public static void main(String[] args) {
        BitMapTest bitMap = new BitMapTest(360000L);
        bitMap.setBit(360000L);
        System.out.println(bitMap.getBit(360000L));
        System.out.println(bitMap.getBit(1));
    }

}
