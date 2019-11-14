package xzz.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class MyUdpClient2 {
    public static void main(String[] args) {
        if (args.length < 4){
            System.out.println("error paramaters");
        }
        String ipAddr = args[0];
        int port = Integer.parseInt(args[1]);
        int send_frequence = Integer.parseInt(args[2]);
        SearchClient sc = new SearchClient(ipAddr,port,send_frequence);
        String filename;
        //循环发送数据包
        //filename = "D:\\netty-practice\\UDPpackageHB.log";
        //filename = "D:\\netty-practice\\udpdata.log";
        System.out.println("ipAddr : "+ipAddr+", port: "+port+", filename: ");
        //sc.sendPackage(filename);
        while(true){


            filename = args[3];
            System.out.println("handle file【"+(3-2)+"】 ipAddr : "+ipAddr+", port: "+port+", filename: "+filename);
            sc.sendPackage(filename);


        }
//        while(true){
//
//            for(int i = 3;i<args.length;i++){
//                filename = args[i];
//                System.out.println("handle file【"+(i-2)+"】 ipAddr : "+ipAddr+", port: "+port+", filename: "+filename);
//                sc.sendPackage(filename);
//            }
//
//        }

    }
}
