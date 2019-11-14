package xzz.netty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

public class SearchClient {

    public static final int MessageReceived = 0x99;
    private int scanPort;
    private String ipaddr;
    private int send_frequence;
    String filename1 = "UDPpackageHB.log";
    //String filename2 = "D:\\UDPpackageAndErrorNetty2.log";

    public static String sendStr = "{\"dType\":\"0001\",\"pType\":\"0001\",\"userID\": \"thlkj-1769096235\", \"pMessage\":{\"v1\":34,\"v2\":\"20142616\",\"v3\":35}}";

    public static String jsonStr1 = "{\"dType\":\"0001\",\"pType\":\"0001\",\"userId\":\"thlkj-1769096235\",\"pMessage\":{\"LOCO_TYPEID\":123,\"LOCO_NO\":123,\"LOCO_AB\":'A',\"LKJ_FAC\":\"株所\",\"LKJ_TIME\":\"2017-09-04 13:23:44\",\"DRIVER_ID\":123,\"VICEDRIVER_ID\":123,\"CHECI_NAME\":\"T140\",\"BENBU\":\"本务\",\"KEHUO\":\"货车\",\"INPUT_JIAOLU\":123,\"FACT_JIAOLU\":123,\"STATION_NO\":123,\"TOTAL_WEIGHT\":123,\"LENGTH\":123,\"VEHICLE_COUNT\":123,\"SPEED\":123,\"LIMITED_SPEED\":123,\"ENGINE_SPEED\":123,\"GUANYA\":123,\"GANGYA\":123,\"WORK_STATUS\":123,\"ZHIDONG\":123,\"LOCO_SIGNAL\":123,\"LINE_NO\":123,\"LINEFLAG_SXX\":\"上行\",\"LINEFLAG_ZSX\":\"主线\",\"LINEFLAG_ZFX\":\"正向\",\"LINEFLAG_GLB\":123,\"STATION_TMIS\":123,\"FRONT_LINEFLAG_SXX\":\"上行\",\"FRONT_LINEFLAG_ZSX\":\"主线\",\"FRONT_LINEFLAG_ZFX\":\"正向\",\"FRONT_LINEFLAG_GLB\":123,\"FRONT_LINENO\":123,\"FRONT_STATION_TMIS\":123,\"FRONT_STATION_JIAOLU\":123,\"FRONT_STATION_NO\":123,\"KILO_SIGN\":123,\"FRONT_DISTANCE\":123,\"SIGNAL_TYPE\":123,\"SIGNAL_NO\":123,\"TOTAL_DISTANCE\":123,\"JKSTATE\":\"出库\",\"CURR_LATERAL\":123,\"CURR_SIDETRACK\":123,\"FRONT_LATERAL\":123,\"FRONT_SIDETRACK\":123,\"WHEEL\":1050.2,\"KCBZ\":\"LKJ\",\"JG1PRESS\":123,\"JG2PRESS\":123,\"BAK_WHEEL\":1050.1}}";

    public SearchClient(String ipaddr,int scanPort,int send_frequence) {
        this.ipaddr = ipaddr;
        this.scanPort = scanPort;
        this.send_frequence = send_frequence;
    }


    private static class CLientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {

            System.out.println(packet.sender().getAddress().toString()+":"+packet.sender().getPort());
            ByteBuf mainPacket = packet.content();
            String  body =  packet.content().toString(CharsetUtil.UTF_8);


            int length = mainPacket.readableBytes();
            byte[] array = new byte[length];
            mainPacket.getBytes(0, array);

            String  body1 =  StringHexUtil.BytesToString(array);

            System.out.println("receive message:" + body1);
            //这里接收到服务端发送的内容


        }
    }

    public void readFile_SendMessage(String filename,Channel ch){

        File file = new File(filename);
        BufferedReader reader = null;

        try {
            System.out.println("以行为单位读取文件内容，一次读一行");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            byte[] buff;

            int count = 0;
            //一次读一行，读入null时文件结束

            while ((tempString = reader.readLine()) != null) {
                //把当前行号显示出来
                System.out.println("line " + line + ": " + tempString);
                if(tempString.contains("recieve message-")){

                    String[] Str = tempString.split(":");
                    String message_head = Str[0];
                    String message = Str[1];
                    buff = StringHexUtil.StringToBytes(message);

                    Str = message_head.split("-");
                    String timeStampStr = Str[1];
                    long timeStamp = Long.parseLong(timeStampStr);
                    byte sDevice = ByteUtil.getByte(buff, 4);
                    int lineNum = ByteUtil.getShort(buff, 10);
                    int messageType = ByteUtil.getShort(buff, 6);
                    int train_num = ByteUtil.getInt(buff, 14);

                    //通过timeStamp对比时间

                    //修改内部时间报文时间


                    //重新计算校验值


                    ch.writeAndFlush(new DatagramPacket(
                            Unpooled.copiedBuffer(buff),
                            new InetSocketAddress(ipaddr, scanPort))).sync();

                    System.out.println("Searh sendPackage()");

                    if(count % send_frequence == 0){

                        Thread.sleep(1000);
                        count = 0;
                    }

                    count++;
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

    }


    public void sendPackage(String filename) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new CLientHandler());

            Channel ch = b.bind(0).sync().channel();

            readFile_SendMessage(filename,ch);





/*
            if (!ch.closeFuture().await(5000)) {
                System.err.println("Search request timed out.");
            }
*/



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Search An Error Occur");
        }
        finally {
            group.shutdownGracefully();
        }
    }

}