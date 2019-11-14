package xzz.netty;

public class StringHexUtil {
    //将十六进制字符串转为byte[]
    public static byte[] StringToBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr,16);

        }
        return bytes;
    }
    //将byte数组转换成16进制字符串
    public static String BytesToString(byte[] buffer){
        String hString = "";
        for (int i=0;i<buffer.length;i++){
            String temp = Integer.toHexString(buffer[i] & 0xFF);
            if(temp.length() ==1){
                temp = "0" + temp;
            }
            hString = hString +temp;
        }
        return hString;

    }

    public static void main(String[] args) {
        String str = "E7ABAF";
        String getStr;
        byte[] buffer = StringToBytes(str);
        getStr = BytesToString( buffer);
        System.out.println(getStr);
        System.out.println(buffer);
        String newStr;
        try {
            newStr = new String(buffer,"utf-8");
            System.out.println(newStr);
        }catch ( Exception e){
            e.printStackTrace();
        }
    }

}