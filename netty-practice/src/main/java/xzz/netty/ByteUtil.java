package xzz.netty;
/**
 * @author xzz
 * @time 2019-11-12
 * 通过byte数组取到指定字节中的特定bit位
 */
public  class ByteUtil {
    /**
     * @author DengJian
     * 通过byte数组取到指定字节中的特定bit位
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     * @param bitOffset 获取数据所在字节中的位偏移
     * @param bitLen 获取数据所在字节中的位长度
     *
     * @return -1：出错，其他为正常值
     */
    public static int getBit_8(byte[] buff, int byteOffset,int bitOffset,int bitLen) {

        if(bitOffset+bitLen>8){
            return -1;
        }

        byte b = buff[byteOffset];
        switch(bitLen){
            case 1:
                return b >> bitOffset & 0x01;
            case 2:
                return b >> bitOffset & 0x03;
            case 3:
                return b >> bitOffset & 0x07;
            case 4:
                return b >> bitOffset & 0x0f;
            case 5:
                return b >> bitOffset & 0x1f;
            case 6:
                return b >> bitOffset & 0x3f;
            case 7:
                return b >> bitOffset & 0x7f;
            case 8:
                return b >> bitOffset & 0xff;
            default:
                return -1;

        }
    }

    /**
     * @author DengJian
     * 通过byte数组取到指定2字节中获取特定bit位值,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     * @param bitOffset 获取数据所在字节中的位偏移
     * @param bitLen 获取数据所在字节中的位长度
     *
     * @return -1：出错，其他为正常值
     */
    public static int getBit_16_big(byte[] buff, int byteOffset,int bitOffset,int bitLen) {

        if(bitOffset+bitLen>16){
            return -1;
        }

        short st = (short)(((buff[byteOffset + 0] << 8) | buff[byteOffset + 1] & 0xff));

        switch(bitLen){
            case 1:
                return st >> bitOffset & 0x0001;
            case 2:
                return st >> bitOffset & 0x0003;
            case 3:
                return st >> bitOffset & 0x0007;
            case 4:
                return st >> bitOffset & 0x000f;
            case 5:
                return st >> bitOffset & 0x001f;
            case 6:
                return st >> bitOffset & 0x003f;
            case 7:
                return st >> bitOffset & 0x007f;
            case 8:
                return st >> bitOffset & 0x00ff;
            case 9:
                return st >> bitOffset & 0x01ff;
            case 10:
                return st >> bitOffset & 0x03ff;
            case 11:
                return st >> bitOffset & 0x07ff;
            case 12:
                return st >> bitOffset & 0x0fff;
            case 13:
                return st >> bitOffset & 0x1fff;
            case 14:
                return st >> bitOffset & 0x3fff;
            case 15:
                return st >> bitOffset & 0x7fff;
            case 16:
                return st >> bitOffset & 0xffff;
            default:
                return -1;

        }
    }

    /**
     * @author DengJian
     * 通过byte数组取到指定2字节中获取特定bit位值,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     * @param bitOffset 获取数据所在字节中的位偏移
     * @param bitLen 获取数据所在字节中的位长度
     *
     * @return -1：出错，其他为正常值
     */
    public static int getBit_16_little(byte[] buff, int byteOffset,int bitOffset,int bitLen) {

        if(bitOffset+bitLen>16){
            return -1;
        }

        short st = (short)(((buff[byteOffset + 1] << 8) | buff[byteOffset + 0] & 0xff));

        switch(bitLen){
            case 1:
                return st >> bitOffset & 0x0001;
            case 2:
                return st >> bitOffset & 0x0003;
            case 3:
                return st >> bitOffset & 0x0007;
            case 4:
                return st >> bitOffset & 0x000f;
            case 5:
                return st >> bitOffset & 0x001f;
            case 6:
                return st >> bitOffset & 0x003f;
            case 7:
                return st >> bitOffset & 0x007f;
            case 8:
                return st >> bitOffset & 0x00ff;
            case 9:
                return st >> bitOffset & 0x01ff;
            case 10:
                return st >> bitOffset & 0x03ff;
            case 11:
                return st >> bitOffset & 0x07ff;
            case 12:
                return st >> bitOffset & 0x0fff;
            case 13:
                return st >> bitOffset & 0x1fff;
            case 14:
                return st >> bitOffset & 0x3fff;
            case 15:
                return st >> bitOffset & 0x7fff;
            case 16:
                return st >> bitOffset & 0xffff;
            default:
                return -1;

        }
    }

    /**
     * @author DengJian
     * 通过byte数组获取8位有符号整形
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getInt8(byte[] buff,int byteOffset){

        return (int) buff[byteOffset];

    }

    /**
     * @author DengJian
     * 通过byte数组获取8位无符号整形
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getUInt8(byte[] buff,int byteOffset){

        return (int)(buff[byteOffset]&0xFF);

    }

    /**
     * @author DengJian
     * 通过byte数组获取16位有符号整形 ,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getInt16_big(byte[] buff,int byteOffset){

        return (int) (((buff[byteOffset + 0] << 8)
                | buff[byteOffset + 1] & 0xff));

    }

    /**
     * @author DengJian
     * 通过byte数组获取16位有符号整形 ,小端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getInt16_little(byte[] buff,int byteOffset){

        return (int) (((buff[byteOffset + 1] << 8)
                | buff[byteOffset + 0] & 0xff));

    }

    /**
     * @author DengJian
     * 通过byte数组获取16位无符号整形 ,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getUInt16_big(byte[] buff,int byteOffset){

        return (int) (((buff[byteOffset + 0] << 8)
                | buff[byteOffset + 1] & 0xff)
                &0xFFFF);

    }

    /**
     * @author DengJian
     * 通过byte数组获取16位无符号整形 ,小端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getUInt16_little(byte[] buff,int byteOffset){

        return (int) (((buff[byteOffset + 1] << 8)
                | buff[byteOffset + 0] & 0xff)
                &0xFFFF);

    }

    /**
     * @author DengJian
     * 通过byte数组获取32位有符号整形 ,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getInt32_big(byte[] buff,int byteOffset){

        return (int) ((((buff[byteOffset + 0] & 0xff) << 24)
                | ((buff[byteOffset + 1] & 0xff) << 16)
                | ((buff[byteOffset + 2] & 0xff) << 8)
                | ((buff[byteOffset + 3] & 0xff) << 0)));

    }

    /**
     * @author DengJian
     * 通过byte数组获取32位有符号整形 ,小端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static int getInt32_little(byte[] buff,int byteOffset){

        return (int) ((((buff[byteOffset + 3] & 0xff) << 24)
                | ((buff[byteOffset + 2] & 0xff) << 16)
                | ((buff[byteOffset + 1] & 0xff) << 8)
                | ((buff[byteOffset + 0] & 0xff) << 0)));

    }

    /**
     * @author DengJian
     * 通过byte数组获取32位无符号整形 ,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static long getUInt32_big(byte[] buff,int byteOffset){

        return (long) (((((long)buff[byteOffset + 0] & 0xff) << 24)
                | (((long)buff[byteOffset + 1] & 0xff) << 16)
                | (((long)buff[byteOffset + 2] & 0xff) << 8)
                | (((long)buff[byteOffset + 3] & 0xff) << 0))
                &0xFFFFFFFF);

    }

    /**
     * @author DengJian
     * 通过byte数组获取32位无符号整形 ,小端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static long getUInt32_little(byte[] buff,int byteOffset){

        return (long) (((((long)buff[byteOffset + 3] & 0xff) << 24)
                | (((long)buff[byteOffset + 2] & 0xff) << 16)
                | (((long)buff[byteOffset + 1] & 0xff) << 8)
                | (((long)buff[byteOffset + 0] & 0xff) << 0))
                &0xFFFFFFFF);

    }

    /**
     * @author DengJian
     * 通过byte数组获取64位有符号整形 ,大端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static long getLong64_big(byte[] buff,int byteOffset){

        return ((((long) buff[byteOffset + 0] & 0xff) << 56)
                | (((long) buff[byteOffset + 1] & 0xff) << 48)
                | (((long) buff[byteOffset + 2] & 0xff) << 40)
                | (((long) buff[byteOffset + 3] & 0xff) << 32)
                | (((long) buff[byteOffset + 4] & 0xff) << 24)
                | (((long) buff[byteOffset + 5] & 0xff) << 16)
                | (((long) buff[byteOffset + 6] & 0xff) << 8)
                | (((long) buff[byteOffset + 7] & 0xff) << 0));

    }

    /**
     * @author DengJian
     * 通过byte数组获取64位有符号整形 ,小端模式
     *
     * @param buff 传入的byte数组
     * @param byteOffset 获取数据所在数组的字节偏移
     *
     *
     * @return
     */
    public static long getLong64_little(byte[] buff,int byteOffset){

        return ((((long) buff[byteOffset + 7] & 0xff) << 56)
                | (((long) buff[byteOffset + 6] & 0xff) << 48)
                | (((long) buff[byteOffset + 5] & 0xff) << 40)
                | (((long) buff[byteOffset + 4] & 0xff) << 32)
                | (((long) buff[byteOffset + 3] & 0xff) << 24)
                | (((long) buff[byteOffset + 2] & 0xff) << 16)
                | (((long) buff[byteOffset + 1] & 0xff) << 8)
                | (((long) buff[byteOffset + 0] & 0xff) << 0));

    }

    public static byte[] getSubByteBuff(byte[] buff,int byteOffset,int byteLen){

        if(byteOffset + byteLen > buff.length){
            return null;
        }
        byte[] rsbuff = new byte[byteLen];
        System.arraycopy(buff, byteOffset, rsbuff, 0, byteLen);
        return rsbuff;
    }





    /**
     * 转换short为byte
     *
     * @param b
     * @param s
     *            需要转换的short
     * @param index
     */
    public static void putShort(byte b[], short s, int index) {
        b[index + 1] = (byte) (s >> 8);
        b[index + 0] = (byte) (s >> 0);
    }

    /**
     * 通过byte数组取到short
     *
     * @param b
     * @param index
     *            第几位开始取
     * @return
     */
    public static short getShort_Little(byte[] b, int index) {
        return (short) (((b[index + 1] << 8) | b[index + 0] & 0xff));
    }

    /**
     * 通过byte数组取出一个字节，并转化成short
     *
     * @param b
     * @param index
     *            第几位开始取
     * @return
     */
    public static byte getByte(byte[] b, int index) {
        return  (b[index]);
    }

    /**
     * 通过byte数组取到short
     *
     * @param b
     * @param index
     *            第几位开始取
     * @return
     */
    public static short getShort(byte[] b, int index) {
        return (short) (((b[index + 0] << 8) | b[index + 1] & 0xff));
    }

    /**
     * 转换int为byte数组
     *
     * @param bb
     * @param x
     * @param index
     */
    public static void putInt(byte[] bb, int x, int index) {
        bb[index + 3] = (byte) (x >> 24);
        bb[index + 2] = (byte) (x >> 16);
        bb[index + 1] = (byte) (x >> 8);
        bb[index + 0] = (byte) (x >> 0);
    }

    /**
     * 通过byte数组取到int
     *
     * @param bb
     * @param index
     *            第几位开始
     * @return
     */
    public static int getInt_Little(byte[] bb, int index) {
        return (int) ((((bb[index + 3] & 0xff) << 24)
                | ((bb[index + 2] & 0xff) << 16)
                | ((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));
    }

    /**
     * 通过byte数组取到int
     *
     * @param bb
     * @param index
     *            第几位开始
     * @return
     */
    public static int getInt(byte[] bb, int index) {
        return (int) ((((bb[index] & 0xff) << 24)
                | ((bb[index + 1] & 0xff) << 16)
                | ((bb[index + 2] & 0xff) << 8) | ((bb[index + 3] & 0xff) << 0)));
    }

    /**
     * 转换long型为byte数组
     *
     * @param bb
     * @param x
     * @param index
     */
    public static void putLong(byte[] bb, long x, int index) {
        bb[index + 7] = (byte) (x >> 56);
        bb[index + 6] = (byte) (x >> 48);
        bb[index + 5] = (byte) (x >> 40);
        bb[index + 4] = (byte) (x >> 32);
        bb[index + 3] = (byte) (x >> 24);
        bb[index + 2] = (byte) (x >> 16);
        bb[index + 1] = (byte) (x >> 8);
        bb[index + 0] = (byte) (x >> 0);
    }
    /**
     * 转换long型为byte数组
     *
     * @param bb
     * @param x
     * @param index
     */
    public static void putLong_big(byte[] bb, long x, int index) {
        bb[index + 0] = (byte) (x >> 56);
        bb[index + 1] = (byte) (x >> 48);
        bb[index + 2] = (byte) (x >> 40);
        bb[index + 3] = (byte) (x >> 32);
        bb[index + 4] = (byte) (x >> 24);
        bb[index + 5] = (byte) (x >> 16);
        bb[index + 6] = (byte) (x >> 8);
        bb[index + 7] = (byte) (x >> 0);
    }

    /**
     * 通过byte数组取到long
     *
     * @param bb
     * @param index
     * @return
     */
    public static long getLong(byte[] bb, int index) {
        return ((((long) bb[index + 7] & 0xff) << 56)
                | (((long) bb[index + 6] & 0xff) << 48)
                | (((long) bb[index + 5] & 0xff) << 40)
                | (((long) bb[index + 4] & 0xff) << 32)
                | (((long) bb[index + 3] & 0xff) << 24)
                | (((long) bb[index + 2] & 0xff) << 16)
                | (((long) bb[index + 1] & 0xff) << 8) | (((long) bb[index + 0] & 0xff) << 0));
    }

    /**
     * 字符到字节转换
     *
     * @param ch
     * @return
     */
    public static void putChar(byte[] bb, char ch, int index) {
        int temp = (int) ch;
        // byte[] b = new byte[2];
        for (int i = 0; i < 2; i ++ ) {
            bb[index + i] = new Integer(temp & 0xff).byteValue(); // 将最高位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
    }

    /**
     * 字节到字符转换
     *
     * @param b
     * @return
     */
    public static char getChar(byte[] b, int index) {
        int s = 0;
        if (b[index + 1] > 0)
            s += b[index + 1];
        else
            s += 256 + b[index + 0];
        s *= 256;
        if (b[index + 0] > 0)
            s += b[index + 1];
        else
            s += 256 + b[index + 0];
        char ch = (char) s;
        return ch;
    }

    /**
     * float转换byte
     *
     * @param bb
     * @param x
     * @param index
     */
    public static void putFloat(byte[] bb, float x, int index) {
        // byte[] b = new byte[4];
        int l = Float.floatToIntBits(x);
        for (int i = 0; i < 4; i++) {
            bb[index + i] = new Integer(l).byteValue();
            l = l >> 8;
        }
    }

    /**
     * 通过byte数组取得float
     *
     * @param b
     * @param index
     * @return
     */
    public static float getFloat(byte[] b, int index) {
        int l;
        l = b[index + 0];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return Float.intBitsToFloat(l);
    }

    /**
     * double转换byte
     *
     * @param bb
     * @param x
     * @param index
     */
    public static void putDouble(byte[] bb, double x, int index) {
        // byte[] b = new byte[8];
        long l = Double.doubleToLongBits(x);
        for (int i = 0; i < 4; i++) {
            bb[index + i] = new Long(l).byteValue();
            l = l >> 8;
        }
    }

    /**
     * 通过byte数组取得float
     *
     * @param b
     * @param index
     * @return
     */
    public static double getDouble(byte[] b, int index) {
        long l;
        l = b[0];
        l &= 0xff;
        l |= ((long) b[1] << 8);
        l &= 0xffff;
        l |= ((long) b[2] << 16);
        l &= 0xffffff;
        l |= ((long) b[3] << 24);
        l &= 0xffffffffl;
        l |= ((long) b[4] << 32);
        l &= 0xffffffffffl;
        l |= ((long) b[5] << 40);
        l &= 0xffffffffffffl;
        l |= ((long) b[6] << 48);
        l &= 0xffffffffffffffl;
        l |= ((long) b[7] << 56);
        return Double.longBitsToDouble(l);
    }


    public static long convertBigLong2Wl_BbLong(long src){
        byte[] buf = new byte[8];
        ByteUtil.putLong_big(buf, src, 0);
//		System.out.println(StringHexUtil.BytestoString(buf));
        byte[] re_buf = new byte[4];
        System.arraycopy(buf, 6, re_buf, 0, 2);
        System.arraycopy(buf, 4, re_buf, 2, 2);
//		System.out.println(StringHexUtil.BytestoString(re_buf));
        long result = ByteUtil.getUInt32_big(re_buf, 0);
//		System.out.println(result);
        return result;

    }

}


class DataTypeChangeHelper {
    /**
     * 将一个单字节的byte转换成32位的int
     *
     * @param b
     *            byte
     * @return convert result
     */
    public static int unsignedByteToInt(byte b) {
        return (int) b & 0xFF;
    }

    /**
     * 将一个单字节的Byte转换成十六进制的数
     *
     * @param b
     *            byte
     * @return convert result
     */
    public static String byteToHex(byte b) {
        int i = b & 0xFF;
        return Integer.toHexString(i);
    }

    /**
     * 将一个4byte的数组转换成32位的int
     *
     * @param buf
     *            bytes buffer
     * @byte[]中开始转换的位置
     * @return convert result
     */
    public static long unsigned4BytesToInt(byte[] buf, int pos) {
        int firstByte = 0;
        int secondByte = 0;
        int thirdByte = 0;
        int fourthByte = 0;
        int index = pos;
        firstByte = (0x000000FF & ((int) buf[index]));
        secondByte = (0x000000FF & ((int) buf[index + 1]));
        thirdByte = (0x000000FF & ((int) buf[index + 2]));
        fourthByte = (0x000000FF & ((int) buf[index + 3]));
        index = index + 4;
        return ((long) (firstByte << 24 | secondByte << 16 | thirdByte << 8 | fourthByte)) & 0xFFFFFFFFL;
    }

    /**
     * 将16位的short转换成byte数组
     *
     * @param s
     *            short
     * @return byte[] 长度为2
     * */
    public static byte[] shortToByteArray(short s) {
        byte[] targets = new byte[2];
        for (int i = 0; i < 2; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((s >>> offset) & 0xff);
        }
        return targets;
    }

    /**
     * 将32位整数转换成长度为4的byte数组
     *
     * @param s
     *            int
     * @return byte[]
     * */
    public static byte[] intToByteArray(int s) {
        byte[] targets = new byte[2];
        for (int i = 0; i < 4; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((s >>> offset) & 0xff);
        }
        return targets;
    }

    /**
     * long to byte[]
     *
     * @param s
     *            long
     * @return byte[]
     * */
    public static byte[] longToByteArray(long s) {
        byte[] targets = new byte[2];
        for (int i = 0; i < 8; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((s >>> offset) & 0xff);
        }
        return targets;
    }

    /**32位int转byte[]*/
    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];
        targets[0] = (byte) (res & 0xff);// 最低位
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }

    /**
     * 将长度为2的byte数组转换为16位int
     *
     * @param res
     *            byte[]
     * @return int
     * */
    public static int byte2int(byte[] res) {
        // res = InversionByte(res);
        // 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
        int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00); // | 表示安位或
        return targets;
    }

}
